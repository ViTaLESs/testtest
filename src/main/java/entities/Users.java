package entities;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Users {

    private String email;
    private String nicName;
    private String password;

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public Users(HashMap<String, String> userInfo, boolean isGenerateEmail){
        log.info("Create new user");
        this.email = (isGenerateEmail) ? generateEmail(userInfo.get("email")) : userInfo.get("email");
        this.nicName = userInfo.get("nicName");
        this.password = userInfo.get("password");
    }


    private String generateEmail(String Email){
        log.info("Start generate user's email");
        String newEmail = "";
        String email = "param@gmail.com";
        String regExp = "(\\S+)(\\@\\S+)";
        Pattern pt = Pattern.compile(regExp);
        Matcher m = pt.matcher(email);
        m.find();
        newEmail = m.group(1) + generateNumber() + m.group(2);

        log.info("Finish generate user's email");
        return newEmail;
    }
    private String generateNumber(){
        String num ;
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yymmhhmmss");
        num = sdf.format(cal.getTime());
        return num;
    }

    public String getEmail() {
        return email;
    }

    public String getNicName() {
        return nicName;
    }

    public String getPassword() {
        return password;
    }

}
