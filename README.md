# WreckItRalph
#### By: [Zaid Albustami](https://github.com/ZaidA2023) and Kevin Hyunh

Java Password Cracker 


### Capabilities

- Top 10,000 most common passwords can be cracked
- Plain-text can be encrypted
- MD5 hashed passwords can be cracked
- BCrypt hashed passwords can be cracked
- SHA-256 hashed passwords can be cracked
- Brute force approach
- Dictionary Attack approach
- Can be run through a terminal

### Command Line Arguments

	There is only one, your password :)

### How-To
	
This program requires a jdk download, preferably 19, which can be found [here](https://download.oracle.com/java/19/latest/jdk-19_windows-x64_bin.exe)
Once the jdk is downloaded you must find the exact path to the java.exe program. 
It is usually 'C:\Users\*Your username*\.jdks\openjdk-19.0.1\bin\java.exe' <-- Try that first and if it doesn't work then find it manually
Anyway, the pre-run commands are as follows	
	cd *filepath to the folder holding the jar file* 
for example mine is 

	cd C:\Users\zaid2\IdeaProjects\PasswordCracker\out\artifacts

It could be something as simple as 

	cd C:\Users\*Username*\Desktop 

if you downloaded it onto the Desktop
You should see that you are now in the jar file folder
After that, type an & sign and then the path to the java.exe file we found above. Then "-jar" followed by the jar file name (pass.jar)
For example

	 & 'C:\Users\zaid2\.jdks\openjdk-19.0.1\bin\java.exe' -jar pass.jar

### Bugs/Issues

1. For BCrypt, the more rounds used to encrypt the password, the longer it takes
to decrypt. It increases exponentially so while a 4 round might be quick, a 6 
round might take a lot longer.
2. A user might want to skip using the jar file and run it straight from an
IDE but it will not work since the filepaths are absolute in the code, they
have to be manually changed to the filepath of the text files being read.
