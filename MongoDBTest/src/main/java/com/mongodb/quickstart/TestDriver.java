package com.mongodb.quickstart;

public class TestDriver {
    public static void main(String[] args) throws Exception {
        // UserModel dataUser = new UserModel("testId");
        // Create create = new Create();
        // create.insertRecord(dataUser,"user");
        testRead();
    }

    public static void testRead() throws Exception {
        Read read = new Read();
        read.getByUserId("testId", "user");
    }
}
