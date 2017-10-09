package com.eImpuestos.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.List;
import com.veranitou.dao.configuration;

public class configuracionDao {

    @Test
    public void testConfig(){
	configuration cfg = new configuration();
	int a = 5;
	assertEquals(6,a);
    }

}
