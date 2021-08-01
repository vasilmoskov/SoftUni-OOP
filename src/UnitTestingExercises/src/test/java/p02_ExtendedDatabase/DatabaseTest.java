package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;
    private Person person7;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.person1 = new Person(1, "Qze");
        this.person2 = new Person(2, "Nikolay");
        this.person3 = new Person(3, "Angel");
        this.person4 = new Person(4, "Sakata");
        this.person5 = new Person(5, "Emo");
        this.person6 = new Person(6, "Vladko");
        this.person7 = new Person(7, "Vaseto");

        this.database = new Database(person1, person2, person3, person4, person5, person6, person7);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithZeroElementsShouldThrow() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThanAllowedElementsShouldThrow() throws OperationNotSupportedException {
        Person person8 = new Person(8, "Vaseto");
        Person person9 = new Person(9, "Vaseto");
        Person person10 = new Person(10, "Vaseto");
        Person person11 = new Person(11, "Vaseto");
        Person person12 = new Person(12, "Vaseto");
        Person person13 = new Person(13, "Vaseto");
        Person person14 = new Person(14, "Vaseto");
        Person person15 = new Person(15, "Vaseto");
        Person person16 = new Person(16, "Vaseto");
        Person person17 = new Person(17, "Vaseto");
        Database database = new Database(person1,person2,person3, person4, person5,
                person6, person7, person8, person9, person10, person11, person12, person13,
                person14, person15, person16, person17);
    }

    @Test
    public void testConstructorWithElementsInBeetweenRangeShouldCreateDatabase() throws OperationNotSupportedException {
        Person person8 = new Person(8, "Vaseto");
        Person person9 = new Person(9, "Vaseto");
        Person person10 = new Person(10, "Vaseto");
        Person person11 = new Person(11, "Vaseto");
        Person person12 = new Person(12, "Vaseto");
        Person person13 = new Person(13, "Vaseto");
        Person person14 = new Person(14, "Vaseto");
        Person person15 = new Person(15, "Vaseto");
        Person person16 = new Person(16, "Vaseto");
        Database database = new Database(person1,person2,person3, person4, person5,
                person6, person7, person8, person9, person10, person11, person12, person13,
                person14, person15, person16);

        Assert.assertEquals(16, database.getElements().length);
    }



    //Add and Remove methods not tested

    @Test
    public void testAddingPersonShouldPutHimAtLastPositionInDatabase() throws OperationNotSupportedException {
        Person person = new Person(8, "Joro");

        this.database.add(person);

        Assert.assertSame(person, this.database.getElements()[7]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddingPersonWithUndefinedFieldsShouldThrow() throws OperationNotSupportedException {
        Person person = null;
        this.database.add(person);
    }

    @Test
    public void testRemoveShouldMakeLastPersonDisappearFromDatabase() throws OperationNotSupportedException {
        Person[] peopleBeforeRemove = this.database.getElements();

        Person lastPersonBeforeRemove = peopleBeforeRemove[peopleBeforeRemove.length - 1];

        this.database.remove();

        Person[] peopleAfterRemove = this.database.getElements();

        Person lastPersonAfterRemove = peopleAfterRemove[peopleAfterRemove.length - 1];

        Assert.assertNotSame(lastPersonBeforeRemove, lastPersonAfterRemove);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemovePersonWhenDatabaseIsEmptyShouldThrow() throws OperationNotSupportedException {
        Database database = new Database(person1, person2);
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testFindByIdShouldReturnPersonWithThatId() throws OperationNotSupportedException {

        Person byId = this.database.findById(2);

        Assert.assertSame(byId, person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWhenMorePeopleHaveTheSameId() throws OperationNotSupportedException {

        Person person = new Person(2, "Imposter");
        this.database.add(person);

        Person byId = this.database.findById(2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWhenNoPersonHasSearchedId() throws OperationNotSupportedException {

        Person byId = this.database.findById(8);
    }

    @Test
    public void testFindByUsernameShouldReturnPersonWithThatUsername() throws OperationNotSupportedException {

        Person byUsername = this.database.findByUsername("Angel");

        Assert.assertSame(byUsername, person3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenMorePeopleHaveTheSameUsername() throws OperationNotSupportedException {

        Person person = new Person(2, "Nikolay");
        this.database.add(person);

        Person byUsername = this.database.findByUsername("Nikolay");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWhenUsernameIsNull() throws OperationNotSupportedException {

        Person person = new Person(2, null);
        this.database.add(person);

        Person byUsername = this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdShouldThrowWhenNoPersonHasSearchedUsername() throws OperationNotSupportedException {

        Person byUsername = this.database.findByUsername("Joro");
    }

}
