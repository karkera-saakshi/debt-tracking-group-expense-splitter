package com.saakshi.expense_calculator.schedular;

import com.saakshi.expense_calculator.enums.Direction;
import com.saakshi.expense_calculator.models.Owns;
import com.saakshi.expense_calculator.repositories.OwnsRepo;
import com.saakshi.expense_calculator.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class EmailReminderScheduler {
    @Autowired
    OwnsRepo ownsRepo;
    @Autowired
    EmailService emailService;

    @Scheduled(cron = "0 0 9 * * *")
    public void sendReminders()
    {
        System.out.println("Scheduler running at: " + LocalDate.now());
        LocalDate today = LocalDate.now();
        List<Owns> allOwns = ownsRepo.findAll();
        for (Owns owns: allOwns)
        {
            if(owns.isPaid()==true)
            {
                continue;
            }
            LocalDate dueDate = owns.getDueDate();
            long daysBeforeDue = ChronoUnit.DAYS.between(today, dueDate);
            long daysAfterDue = ChronoUnit.DAYS.between(dueDate, today);
            String userEmail = owns.getUser().getEmail();
            String otherPartyEmail = owns.getOtherPartyEmail();
            String otherPartyName = owns.getOtherPartyName();
            String selfName = owns.getSelfName();
            double amount = owns.getAmount();
            if(daysBeforeDue == owns.getReminderBefore())
            {
                if(owns.getDirection() == Direction.OWNS_ME)
                {
                    //you lent money, remind yourself
                    emailService.sendEmail(userEmail,
                            "Reminder: Payment Due Soon From "+otherPartyName,
                            "Good Morning "+selfName + ",\n\n"+
                                    otherPartyName+" owes you ₹" +amount +".\n"+
                                    "Due Date is "+ dueDate + "("+daysBeforeDue + " days away). \n\n Consider reminding them!"
                    );
                    if(otherPartyEmail!=null)
                    {
                        emailService.sendEmail(userEmail,
                                "Reminder: Payment Due Soon To "+selfName,
                                "Good Morning "+otherPartyName + ",\n\n"+
                                        "You owe "+selfName+" ₹" +amount +".\n"+
                                        "Due Date is "+ dueDate + "("+daysBeforeDue + " days away). \n\n Please arrange the payment!"
                        );
                    }
                }
                if(owns.getDirection()== Direction.I_OWN)
                {
                    //I borrowed, remind yourself
                    emailService.sendEmail(userEmail,
                            "Reminder: Payment Due Soon To "+otherPartyName,
                            "Good Morning "+selfName + ",\n\n"+
                                    "You owe "+otherPartyName+" ₹" +amount +".\n"+
                                    "Due Date is "+ dueDate + "("+daysBeforeDue + " days away). \n\n Please arrange the payment!"
                    );
                }
            }
            if(today.isEqual(dueDate))
            {
                if(owns.getDirection() == Direction.I_OWN)
                {
                    //You have to pay
                    emailService.sendEmail(userEmail,
                            "Reminder: Payment Due Today To"+otherPartyName,
                            "Good Morning "+selfName + ",\n\n"+
                                    "Today is due date! you owe ₹" +amount +" to"+otherPartyName+".\n"+
                                    " \n\n Please arrange the payment!"
                    );
                }
                if(owns.getDirection() == Direction.OWNS_ME)
                {
                    //They have to pay
                    emailService.sendEmail(userEmail,
                            "Due Date Today: Payment Expected From "+otherPartyName,
                            "Good Morning " + selfName + ",\n\n" +
                                    "Today is the due date! " + otherPartyName + " owes you ₹" + amount + ".\n" +
                                    "Follow up if you haven't received it yet."
                    );
                    if (otherPartyEmail != null) {
                        emailService.sendEmail(otherPartyEmail,
                                "Payment Due Today To "+selfName,
                                "Good Morning " + otherPartyName + ",\n\n" +
                                        "Your payment of ₹" + amount + " to " + selfName + " is due TODAY.\n" +
                                        "Please make the payment as soon as possible."
                        );
                    }
                }
            }
            if(daysAfterDue == owns.getReminderAfter())
            {
                if(owns.getDirection() == Direction.I_OWN)
                {
                    //I have to pay
                    emailService.sendEmail(userEmail,
                            "Overdue: You Have a Pending Payment From "+otherPartyName,
                            "Good Morning " + selfName + ",\n\n" +
                                    "Your payment of ₹" + amount + " to " + otherPartyName + " is " + daysAfterDue + " days overdue.\n" +
                                    "Please pay immediately to avoid issues."
                    );
                }
                if(owns.getDirection() == Direction.OWNS_ME)
                {
                    //I have to recieve
                    emailService.sendEmail(userEmail,
                            "Overdue: Payment Not Received From "+otherPartyName,
                            "Good Morning " + selfName + ",\n\n" +
                                    "Payment of ₹" + amount + " from " + otherPartyName + " is " + daysAfterDue + " days overdue.\n" +
                                    "Please follow up immediately."
                    );
                    if (otherPartyEmail != null)
                    {
                        emailService.sendEmail(otherPartyEmail,
                                "Overdue Payment Notice From "+selfName,
                                "Good Morning " + otherPartyName + ",\n\n" +
                                        "Your payment of ₹" + amount + " to " + selfName + " is " + daysAfterDue + " days overdue.\n" +
                                        "Please clear this immediately.");
                    }
                }
            }
        }
    }
}
