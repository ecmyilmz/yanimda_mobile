package core;

import com.sun.applet2.AppletParameters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class User {



    core.Device device;
    private String msisdn;
    private String password;
    private String otp;

    public static HashMap<String, User> users = new HashMap<>();

    public User(String msisdn) { this.msisdn = msisdn; }
    public String getMsisdn() { return msisdn; }
    public String getPassword() { return password; }
    public String getOtp() { return otp; }
    public core.Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }
    
    public static Map<String, User> getUsers() {
        return Collections.unmodifiableMap(users);
    }


    public static class UserBuilder {
        private User user;
        private core.Device device;
        private String msisdn;
        private String password;
        private String otp;

        public UserBuilder user(User user) {
            this.user = user;
            return this;
        }

        public UserBuilder msisdn(User user) {
            this.msisdn = msisdn;
            return this;
        }

        public UserBuilder password(User user) {
            this.password = password;
            return this;
        }

        public UserBuilder otp(User user) {
            this.otp = otp;
            return this;
        }
    }

}

