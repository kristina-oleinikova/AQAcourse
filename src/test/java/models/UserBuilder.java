package models;

public class UserBuilder {
    private String username;
    private String password;
    private int age;
    private int height;
    private int weight;

    public static class Builder{
        private UserBuilder newUser;

        public Builder(){
            this.newUser = new UserBuilder();
        }

        public Builder withUsername(String username){
            newUser.username = username;
            return this;
        }

        public Builder withPassword(String password){
            newUser.password = password;
            return this;
        }

        public Builder withAge(int age){
            newUser.age = age;
            return this;
        }

        public Builder withHeight(int height){
            newUser.height = height;
            return this;
        }

        public Builder withWeight(int weight){
            newUser.weight = weight;
            return this;
        }

        public UserBuilder build(){
            return newUser;
        }
    }
}
