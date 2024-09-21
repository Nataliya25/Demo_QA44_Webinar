package tests;

import manager.ApplicationManager;
import manager.dto.StudentDTO;
import manager.enums.Gender;
import manager.enums.Hobbies;
import manager.enums.StateCity;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends ApplicationManager {

    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> listHobbies = new ArrayList<>();
        listHobbies.add(Hobbies.SPORTS);
        listHobbies.add(Hobbies.MUSIC);

        StudentDTO student = new StudentDTO("Steve", "Silver",
                "silver123@gmail.com", Gender.OTHER, "1234567890",
                "12 Sep 2014", "Math, Physics, Economy", listHobbies, "",
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
    }

}
