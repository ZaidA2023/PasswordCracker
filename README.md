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

After following the How-To down below you are left with a command ending in "pass.jar".
The commands must be written after "pass.jar", be done in this order, and be separated by spaces

1

	-e = Encryption
	-d = Decryption

2
	
	-m = MD5
	-s = SHA-256
	-b = Bcrypt

3

	User input (Hash or Plaintext) within single quotations

#### Example
	& 'C:\Users\zaid2\.jdks\openjdk-19.0.1\bin\java.exe' -jar pass.jar -e -m 'wreck'
Output

	Encryption Result
	MD5 Hash: 02a13d725157a08db3864a8b9f4dfe0c
Or

	& 'C:\Users\zaid2\.jdks\openjdk-19.0.1\bin\java.exe' -jar pass.jar -d -s '7e4353d9a9b2d35e73c461e9c50a1f60a5da42dc4a0f53faac2b7e2d413aca17'	
Output

	Common Password Attack Result
	No result

	Dictionary Attack Result
	Plaintext: wreck
	
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
2. The filepaths of the files used for the rainbow table are absolute and therefore must be changed for them to work.
However, I found this is only true sometimes, sometimes the code gives a FileNotFound error and others it works although the file
paths are not correct.
