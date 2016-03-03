package com.thejavaside;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    //junit 3
    @Test
    public void testFooThrowsIndexOutOfBoundsException() {
        try {
            throwException();
            fail("IndexOutOfBoundsException should have been thrown ");
        } catch(IndexOutOfBoundsException e) {
            //if execution reaches here, it indicates this exception was occurred.
            //so we need not handle it.
        }
    }

    //junit 4
    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrownException() {
        throwException();
    }


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    //junit 4
    @Test
    public void doStuffThrowsIndexOutOfBoundsException() {

        //the benefit of this approach is that you can write your own matcher to match string and other things.
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("invalid index");
        throwException();
    }

    private void throwException() {
        throw new IndexOutOfBoundsException("invalid index");
    }
}
