# S.I.L.O.S
S.I.L.O.S language of the future
 ____     __     __       __     ____ 
/ ___)   (  )   (  )     /  \   / ___)
\___ \ _  )(  _ / (_/\ _(  O )_ \___ \
(____/(_)(__)(_)\____/(_)\__/(_)(____/
Superb
Interpreted
Language's
Obviously
Superior
 .----..-.  .-..-. .-. .---.  .--.  .-.  .-.
{ {__   \ \/ / |  `| |{_   _}/ {} \  \ \/ / 
.-._} }  }  {  | |\  |  | | /  /\  \ / /\ \ 
`----'   `--'  `-' `-'  `-' `-'  `-'`-'  `-'
One command per line
one letter variable names
Only type integer 
No declaration needed they all start at 0
Turing complete direct access to the array like such 
a = get 5
lblFoo
goto Foo
No syntax checking
VB like behabior allowing erros to pass unnoticed and unhandled
if x Foo //goes to Foo iff x>0
a - 5
a + 5
a * 5
a /  5
a % 5
a | //absolute value of a and reassigns this to a
//all assignment operators
         o                                                               
        <|>                                                              
        / \                                                              
      o/   \o       \o__ __o   \o__ __o     o__ __o/   o      o    __o__ 
     <|__ __|>       |     |>   |     |>   /v     |   <|>    <|>  />  \  
     /       \      / \   < >  / \   < >  />     / \  < >    < >  \o     
   o/         \o    \o/        \o/        \      \o/   \o    o/    v\    
  /v           v\    |          |          o      |     v\  /v      <\   
 />             <\  / \        / \         <\__  / \     <\/>  _\o__</   
                                                          /              
                                                         o               
                                                      __/>                
You can directly write to the memory buffer like such
set 288 57
//acccesses the heap at 288 and sets it to 57
a = get 288
//gets back what the thing at position 288
printInt a
set a 88
//sets the thing at position a to 88
b = get a
//gets the thing at position a and sets it in the value of b
printInt b
a + 10
b + 11
set b a
//sets what is at b's position to a
c= get b
//gets the number from above
printInt c
 ___               ___      ________     
|\  \             /  /|    |\   __  \    
\ \  \           /  //     \ \  \|\  \   
 \ \  \         /  //       \ \  \\\  \  
  \ \  \       /  //         \ \  \\\  \ 
   \ \__\     /_ //           \ \_______\
    \|__|    |__|/             \|_______|
                                         
input and output is done like so
readIO SOME PROMPT FOR THE USER
the magical interpreter thus prints out SOME PROMPT FOR THE USER  and stores the value in the variable i
Printing is done with three commands
printInt a
//prints out the value of a with a trailing newline
printLine a
//prints out "a" with a trailing newline
print a
//prints out "a" with no trailing new line
                                                        ______                        
|`````````,       .'.       |..          | |``````.   .~      ~.        .'. .`.       
|'''|'''''      .''```.     |  ``..      | |       | |          |     .'   `   `.     
|    `.       .'       `.   |      ``..  | |       | |          |   .'           `.   
|      `.   .'           `. |          ``| |......'   `.______.'  .'               `. 
                                                                                      
the randomness is provided by a prng currently the
prng is provided courtesy of Oracle and uses the system time as a seed
rand max
gets a random number [0,max) 0 inclusive to max exclusive and stores it in the variable r
_______________________________
      __                       
    /    )              /      
----\------_/_---------/----__-
     \     /    /   / /   /___)
_(____/___(_ __(___/_/___(___ _
                  /            
              (_ /        
the first line is used by the interpreter to allocate the size of the array (heap) this number should be at least 256
if you omit this line the interpretter will just allocate 512 slots in its memory for its future use
you are limited in variable names and due`
1 = 5
printInt 1
//prints five
print 1
//5 
But never do this unless it is for obfuscation purposes the compiler will struggle with resolving what you are talking about
also as far as commenting goes the compiler will ignore non code thus
this is a comment
is valid syntax
but don't do this as
1 = foo
would break your code
instead // is recommended to start all comments
lastly as input and randomness are stored into the variables i and r when requested it is recommended that you reserve these
variables for that use
 .----------------.  .-----------------. .----------------.  .----------------.  .----------------. 
| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
| |  _________   | || | ____  _____  | || |     _____    | || |     ____     | || |  ____  ____  | |
| | |_   ___  |  | || ||_   \|_   _| | || |    |_   _|   | || |   .'    `.   | || | |_  _||_  _| | |
| |   | |_  \_|  | || |  |   \ | |   | || |      | |     | || |  /  .--.  \  | || |   \ \  / /   | |
| |   |  _|  _   | || |  | |\ \| |   | || |   _  | |     | || |  | |    | |  | || |    \ \/ /    | |
| |  _| |___/ |  | || | _| |_\   |_  | || |  | |_' |     | || |  \  `--'  /  | || |    _|  |_    | |
| | |_________|  | || ||_____|\____| | || |  `.___.'     | || |   `.____.'   | || |   |______|   | |
| |              | || |              | || |              | || |              | || |              | |
| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
 '----------------'  '----------------'  '----------------'  '----------------'  '----------------' 
