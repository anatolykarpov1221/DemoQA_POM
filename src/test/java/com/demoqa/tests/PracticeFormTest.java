package com.demoqa.tests;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void createStudentAccountTest() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver)
                .enterPersonalData("Jack","Sparrow","jack@gm.com","1234567890")
                //select gender(radio button)
                .selectGender("Male")
                .enterBirthDay("16 August 1987")
                .enterSubjects(new String[]{"Maths","Chemistry"})
                //select hobby(check box)
                .selectHobby(new String[]{"Sports","Reading"})
                .uploadFile("/Users/anatolykarpovMAC15/tools/1.jpg")
                .selectState("NCR")
                .selectCity("Delhi")
                .clickOnSubmit()
                //assert student form is appeared
                .verifySuccessTitle("Thanks for submitting the form");
    }
}
