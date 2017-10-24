package ua.kharkiv.yeremenko.exIOandRegexp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.kharkiv.yeremenko.exIOandRegexp.part1.Part1Test;
import ua.kharkiv.yeremenko.exIOandRegexp.part2.Part2Test;
import ua.kharkiv.yeremenko.exIOandRegexp.part3.Part3Test;
import ua.kharkiv.yeremenko.exIOandRegexp.part4.Part4Test;
import ua.kharkiv.yeremenko.exIOandRegexp.part5.Part5Test;

@RunWith(Suite.class)
@SuiteClasses({ Part1Test.class, Part2Test.class, Part3Test.class,
		Part4Test.class, Part5Test.class })
public class AllTests {
	
}
