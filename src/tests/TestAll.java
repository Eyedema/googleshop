package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestCategory.class, TestConcreteCart.class, TestConcreteProduct.class, TestPackage.class, TestProductDecorated.class})

public class TestAll {
}


