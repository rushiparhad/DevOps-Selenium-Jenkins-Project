# DevOps CA Project - Selenium + Jenkins

## 📌 Project Overview
This project demonstrates a complete DevOps workflow by integrating:
- Frontend development using HTML, CSS, and JavaScript  
- Automation testing using Selenium WebDriver (Java)  
- Continuous Integration using Jenkins  

---

## 🌐 Frontend (Student Feedback Form)
A responsive and user-friendly feedback form with the following features:

### 🔹 Input Fields
- Student Name  
- Email ID  
- Mobile Number  
- Department (Dropdown)  
- Gender (Radio Buttons)  
- Feedback Comments  

### 🔹 Functionalities
- Form validation using JavaScript  
- Email format validation  
- Mobile number validation (10 digits)  
- Minimum 10-word feedback validation  
- Gender selection (single option)  
- Success popup on submission  

---

## 🤖 Selenium Automation Testing
Automation testing is implemented using Java and Selenium WebDriver.

### ✅ Test Cases Covered
- Verify page loads successfully  
- Submit form with valid data  
- Check validation for empty fields  
- Validate incorrect email format  
- Validate incorrect mobile number  
- Verify dropdown selection  
- Verify Submit and Reset button functionality  

---

## ⚙️ Jenkins Integration
Jenkins is used to automate execution of Selenium test cases.

### 🔹 Steps Performed
- Installed Jenkins using Homebrew  
- Created a Freestyle project  
- Configured build step using "Execute Shell"  
- Executed Selenium test script automatically  

### 🔹 Jenkins Command Used
```bash
cd /Users/rushi/eclipse-workspace/sleniumtesting/bin

java -cp ".:/Users/rushi/Downloads/selenium-java-4.40.0/*:/Users/rushi/Downloads/selenium-java-4.40.0/libs/*" com.demo.sleniumtesting.ca2test
