package com.shiftedtech.qa.script;

import org.junit.Test;

import com.shiftedtech.qa.framework.HeatclinicScriptBase;

/**
 * Created by MOHSEN on 09/21/18.
 */
public class HeatClinicLoginTest extends HeatclinicScriptBase{

    @Test
    public void validUserValidPassword01(){
        System.out.println("********* Test - validUserValidPassword ************");
        homePage().navigateToLoginPage();
        loginPage().login("iivaan@shiftedtech.com","shiftedtech");
        homePage().verifyMyAccountName("Iftekhar");
    }

    @Test
    public void validUserValidPassword02(){
        System.out.println("********* Test - validUserValidPassword ************");
        homePage().navigateToLoginPage();
        loginPage().login("mah123bub@gmail.com","mahbub123");
        homePage().verifyMyAccountName("Mahbub");
    }
}
