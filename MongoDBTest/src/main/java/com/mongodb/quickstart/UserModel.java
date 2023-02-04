package com.mongodb.quickstart;

/**
 * New User Model class
 */
public class UserModel implements DataModel {
    private String userId;
    private String username;
    private String password;
    /**
     * Create new Data based on objectId given.
     * If objectId is null, can use the public method to create new objectId
     *
     * @param userId
     */
    public UserModel(String userId) {
        this.userId = userId;
        this.username = "testUser";
        this.password = "testPassword";
    }
}
