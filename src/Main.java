import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User(1,"Nur","Heybetova"),
                new User(2, "Nemet", "Xelilov"),
                new User(3, "Vusal", "Rehimov")
        );

        userList.stream()
        .filter(user -> {
            if(user.getName().startsWith("N"))
                return true;
            return false;
        })
        .collect(Collectors.toSet()).forEach(System.out::println);

        List<UserResponse> userResponseList = userList.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setSurname(user.getSurname());
            return userResponse;
        }).collect(Collectors.toList());

    }

    static class UserResponse{
        private String name;
        private String surname;

        public UserResponse(){

        }

        public UserResponse(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return "UserResponse{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }
    }

    static class User{
        private Integer id;
        private String name;
        private String surname;

        public User(){

        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        public User(Integer id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public static void printFullName(User user){
            System.out.println(user.name + " " + user.surname);
        }
    }
}
