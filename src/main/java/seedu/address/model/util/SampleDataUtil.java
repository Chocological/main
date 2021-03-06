package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.LoginBook;
import seedu.address.model.ReadOnlyAddressBook;

import seedu.address.model.ReadOnlyLoginBook;
import seedu.address.model.login.LoginDetails;
import seedu.address.model.login.UserId;
import seedu.address.model.login.UserPassword;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Skill;

import seedu.address.model.person.SkillLevel;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} and {@code LoginBook} with sample data.
 */
public class SampleDataUtil {
    public static final Skill EMPTY_SKILL = new Skill("");
    public static final SkillLevel EMPTY_SKILLLEVEL = new SkillLevel(0);
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"), new Skill("Photography"), new SkillLevel(90),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new Skill("Videography"), new SkillLevel(50),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"), new Skill("Design"), new SkillLevel(45),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"), new Skill("Photoshop"), new SkillLevel(50),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"), new Skill("Stage Managing"), new SkillLevel(30),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"), new Skill("Public Speaking"), new SkillLevel(80),
                getTagSet("colleagues"))
        };
    }

    public static LoginDetails[] getSampleLoginDetail() {
        return new LoginDetails[] {
            new LoginDetails(new UserId("A1234567M"), new UserPassword("zaq1xsw2cde3")),
            new LoginDetails(new UserId("A1234568M"), new UserPassword("1qaz2wsx3edc"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlyLoginBook getSampleLoginBook() {
        LoginBook sampleLb = new LoginBook();
        for (LoginDetails sampleAccount : getSampleLoginDetail()) {
            sampleLb.createAccount(sampleAccount);
        }
        return sampleLb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
