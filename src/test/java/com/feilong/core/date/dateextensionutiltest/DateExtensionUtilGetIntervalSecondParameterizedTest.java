/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.date.dateextensionutiltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.feilong.core.bean.ConvertUtil;
import com.feilong.test.AbstractThreeParamsAndOneResultParameterizedTest;

import static com.feilong.core.bean.ConvertUtil.toArray;
import static com.feilong.core.bean.ConvertUtil.toList;
import static com.feilong.core.date.DateExtensionUtil.getIntervalSecond;
import static com.feilong.core.date.DateUtil.toDate;

import static com.feilong.core.DatePattern.COMMON_DATE_AND_TIME;

/**
 * The Class DateExtensionUtilGetIntervalSecondParameterizedTest.
 *
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class DateExtensionUtilGetIntervalSecondParameterizedTest
                extends AbstractThreeParamsAndOneResultParameterizedTest<String, String, String, Integer>{

    /**
     * Test get interval minute.
     */
    @Test
    public void testGetIntervalMinute(){
        assertEquals(expectedValue, (Integer) getIntervalSecond(toDate(input1, input3), toDate(input2, input3)));
    }

    /**
     * Data.
     *
     * @return the iterable
     */
    @Parameters(name = "index:{index}:DateExtensionUtil.getIntervalSecond(toDate(\"{0}\",\"{2}\"), toDate(\"{1}\",\"{2}\"))={3}")
    public static Iterable<Object[]> data(){
        return toList(//
                        ConvertUtil.<Object> toArray("2016-08-22 00:00:00", "2016-08-22 00:00:08", COMMON_DATE_AND_TIME, 8),

                        toArray("2016-08-21 23:59:20", "2016-08-22 00:00:20", COMMON_DATE_AND_TIME, 60)
        //  
        );
    }
}