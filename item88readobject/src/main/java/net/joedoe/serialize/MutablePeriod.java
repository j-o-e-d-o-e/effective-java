package net.joedoe.serialize;

import java.io.*;
import java.util.Date;

public class MutablePeriod {
    public final Period period;     // A period instance
    public final Date start;        // period's start field, to which we shouldn't have access
    public final Date end;          // period's end field, to which we shouldn't have    access

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(new Period(new Date(), new Date()));    // Serialize a valid Period instance
            /*
             * Append rogue "previous object refs" for internal
             * Date fields in Period. For details, see  "Java
             * Object Serialization Specification," Section 6.4.
             */
            byte[] ref = {0x71, 0, 0x7e, 0, 5};                     // Ref #5
            bos.write(ref);                                         // The start field
            ref[4] = 4;                                             // Ref # 4
            bos.write(ref);                                         // The end field
            // Deserialize Period and "stolen" Date references
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}

