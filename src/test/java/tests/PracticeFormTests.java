package tests;

import manager.ApplicationManager;
import manager.dto.StudentDTO;
import manager.enums.Gender;
import manager.enums.Hobbies;
import manager.enums.StateCity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends ApplicationManager {

    SoftAssert softAssert = new SoftAssert();
    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);

        StudentDTO student = new StudentDTO("Steve", "Silver",
                "silver123@gmail.com", Gender.OTHER, "1234567890",
                "12 Sep 2014", "Math, Physics, Economics", listHobbies, "",
                "Tel Aviv st.Herzel 2",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        // StudentDTO student = new StudentDTO();
        //        student.setName("Stive");
        //        student.setLastName("Silver");
        //        student.setEmail("silver123@gmail.com");
        //        student.setGender(Gender.MALE);


        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .fillStudentsForm(student)
                .clickBtnSubmit()
                .isTextToBePresent_textThanksFor());
    }

    @Test
    public void practiceFormPositiveTest_Soft(){
        List<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);

        StudentDTO student = new StudentDTO("Steve", "Silver",
                "silver123@gmail.com", Gender.OTHER, "1234567890",
                "12 Sep 2014", "Math, Physics, Economics", listHobbies, "",
                "Tel Aviv st.Herzel 2",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        // StudentDTO student = new StudentDTO();
        //        student.setName("Stive");
        //        student.setLastName("Silver");
        //        student.setEmail("silver123@gmail.com");
        //        student.setGender(Gender.MALE);


        new HomePage(getDriver())
                .clickBtnForms()
                .clickBtnPracticeForm()
                .fillStudentsForm(student)
                .clickBtnSubmit();


        WebElement elementNameFamily = getDriver().findElement(By.xpath("//tbody/tr[1]/td[last()]"));
        WebElement elementEmail = getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]"));

        softAssert.assertEquals(elementNameFamily.getText(), "Steve Silver");
        softAssert.assertEquals(elementEmail.getText(), "silver123@gmail.com");

        softAssert.assertAll();
    }

}
