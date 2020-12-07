* login information

**important note on logging in

If you supply incorrect information you will be put into an infinite loop, see below for explanation and my troubleshooting steps. Correct information will work though, and you will be able to access all methods in either the employee menus or admin menus. 

admin account: 
  username: admin
  password: 012345

employees:
  username: alistenberger
  password: 1111

  username: slistenberger
  password:1111


** Note on logging:

I have a transaction log saved under the file transactions.txt if you conduct transactions with an employee, they should be recorded there. As of now, I didn't code a method for the program to read back from the log, but it is included in the jar file for you to look at as a .txt


** Note on some known file issues: 


  This update covers the known issues I would like to have fixed before submission

  
  I am working on fixing the login function. I know that it breaks in my loginVerify method if incorrect credentials
 are supplied. I know that it breaks in the current iteration because an infinite loop is established by the while 
loop as the credential is never satisfied so !isValidCredential always returns true. However, I removed the 
while loop and it now breaks when CORRECT credentials are supplied, unless the credentials are for the last employee
 in the last location, in which case it returns true. This edit isn't saved here as I need the employee credentials to work.
So if it breaks for you, it is likely in an infinite loop because the incorrect credentials were supplied, sorry, its a pain, I know. 
 To fix the breakage after removing the while loop, I have attempted to feed it 'break' after it SHOULD have found
 the employee with matching credentials. I have even made it system.out everything it is doing 
(employee username and password vs input username and password) and the status of isValidCredential. 
Even when isValidCredential returns true, which without the while loop I provided a break for this occurance, 
it still jumps to the next location. I feel a nested for loop in this instance is what is breaking it, 
but I cannot figure out how to iterate through every location without one as of yet. 
Maybe if I had more time, I could write a function checking the credentials of employees at each location,
 only proceeding IF the condition has not been met.  


Also of note, if I had more time I wanted to expand on my Scanners to ensure wrong input is properly handled. I just remembered today that Scanner has a hasNext method that returns a boolean. Time permitting, I would've found every instance of scanner and handled the incorrect input.


Another thing I would have liked to have done is add, in addition to my transaction log, a financial log and an employee login log to keep track of more things.

I wanted to make the money transactions more in depth, same with the return deadlines. If I had more time I would implement a real-time datetime class to handle lateReturns and things that I have as manual inputs now like currentDate


