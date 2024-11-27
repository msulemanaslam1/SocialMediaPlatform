package Model;

import java.util.ArrayList;

public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<Comment> comments;
    private ArrayList<Post> posts;
    private ArrayList<Post> likes;

    private ArrayList<User> friends;
    private ArrayList<Integer> friendsIDS;

    public User(){
        posts = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();
        friends = new ArrayList<>();
        friendsIDS = new ArrayList<>();
    }
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public ArrayList<Comment> getComments(){
        return comments;
    }
    public void setComments(ArrayList<Comment> comments){
        this.comments = comments;
    }
    public ArrayList<Post> getPosts(){
        return posts;
    }
    public void setPosts(ArrayList<Post> posts){
        this.posts = posts;
    }
    public ArrayList<Post> getLikes(){
        return likes;
    }
    public void setLikes(ArrayList<Post> likes){
        this.likes = likes;
    }
    public ArrayList<User> getFriends(){
        return friends;
    }
    public void setFriends(ArrayList<User> friends){
        this.friends = friends;
        friendsIDS = new ArrayList<>();
        for(User u: friends){
            friendsIDS.add(u.getID());
        }
    }
    public void setFriendsIDs(ArrayList<Integer> friendsIDS){
        this.friendsIDS = friendsIDS;
    }

    public boolean isFriend(User u){
        return friendsIDS.contains(u.getID());
    }

    public void addFriend(User f) {
        friends.add(f);
        friendsIDS.add(f.getID());
    }

    public void removeFriend(User f) {
        friends.remove(f);
        friendsIDS.remove((Integer) f.getID());
    }

    public ArrayList<Integer> getFriendsIDs() {
        return friendsIDS;
    }
}
