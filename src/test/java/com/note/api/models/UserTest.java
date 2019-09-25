package com.note.api.models;

public class UserTest {

//    private static Boss boss;
//    private User user;
//
//
//    @BeforeClass
//    public static void setUp()
//    {
//        boss = new Boss("Boss","Password");
//        MainDao.save(boss);
//
//    }
//
//    @AfterClass
//    public static void tearDown()  {
//        //MainDao.delete(boss);
//    }
//
//    @Before
//    public void createUser()
//    {
//        user = new User("User","Password");
//    }
//
//    @After
//    public void deleteUser()
//    {
//       // MainDao.delete(user);
//    }
//
//    @Test
//    public void getBoss_id() {
//        MainDao.save(user,boss);
//        Assert.assertNotNull(MainDao.dropFromDataBase(User.class,user.getPersonId()).getBoss_id());
//    }
//
//    @Test
//    public void setBoss_id() {
//
//        MainDao.save(user,boss);
//        Assert.assertEquals(MainDao.dropFromDataBase(User.class,user.getPersonId()),user);
//    }
//
//    @Test
//    public void getNoteSet() {
//        MainDao.save(user,boss);
//        user.getNoteSet().add(new Note("Ala ma kota"));
//        Assert.assertFalse(user.getNoteSet().isEmpty());
//    }
//
//    @Test
//    public void setNoteSet() {
//        Set<Note> noteSet = new TreeSet<>();
//        noteSet.add(new Note("1"));
//        noteSet.add(new Note("2"));
//        noteSet.add(new Note("3"));
//
//        user.setNoteSet(noteSet);
//        user.getNoteSet().forEach(Assert::assertNotNull);
//    }
}