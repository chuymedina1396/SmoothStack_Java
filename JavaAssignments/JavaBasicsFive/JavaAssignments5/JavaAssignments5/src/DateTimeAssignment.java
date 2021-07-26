// 1 Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
    // Instruction do not indicate any need to write any code, so I am assuming you just need a direct text based answer :)

        // ANSWER : LocalDateTime class. This class can track date and time all the way down to the nanosecond.


// 2 Given a random date, how would you find the date of the previous Thursday?
    // Instruction does not indicate any need to write any code, so I am assuming you just need a direct text based answer :)

        // ANSWER: You can the 'previous' method from the TemporalAdjuster class.


// 3 What is the difference between a ZoneId and a ZoneOffset?
    // ANSWER:  
        // Both ZoneId and ZoneOffset track an offset from Greenwich/UTC time, but the ZoneOffset class tracks only the absolute offset from Greenwich/UTC. The ZoneId class also uses the ZoneRules to determine how an offset varies for a particular time of year and region.



// 4 How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
    // ANSWER: ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(),
    //                                         ZoneId.systemDefault());













