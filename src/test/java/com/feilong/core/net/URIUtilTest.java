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
package com.feilong.core.net;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.feilong.core.CharsetType.UTF8;

/**
 * The Class URIUtilTest.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 */
public class URIUtilTest{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(URIUtilTest.class);

    //******************************************************************************************************
    /**
     * Test encode.
     */
    @Test
    public void testEncode(){
        String value = "={}[]今天天气很不错今天天气很不错今天天气很不错今天天气很不错今天天气很不错";
        value = "http://xy2.cbg.163.com/cgi-bin/equipquery.py?server_name=风花雪月&query_order=selling_time DESC&search_page&areaid=2&server_id=63&act=search_browse&equip_type_ids&search_text=斩妖剑";
        value = "斩妖剑";
        value = "风花雪月";
        LOGGER.debug(URIUtil.encode(value, UTF8));
        value = "景儿,么么哒";
        LOGGER.debug(URIUtil.encode(value, UTF8));
        LOGGER.debug(URIUtil.encode("白色/黑色/纹理浅麻灰", UTF8));
        LOGGER.debug(URIUtil.encode("Lifestyle / Graphic,", UTF8));
    }

    /**
     * Test encode2.
     */
    @Test
    public void testEncode2(){
        LOGGER.debug(URIUtil.encode("%", UTF8));
        LOGGER.debug(URIUtil.encode("%25", UTF8));
    }

    /**
     * Decode.
     */
    @Test
    public void decode(){
        LOGGER.debug(
                        URIUtil.decode(
                                        "%E9%87%91%E6%80%BB%EF%BC%8C%E4%BD%A0%E6%83%B3%E6%80%8E%E4%B9%88%E4%B9%88%EF%BC%8C%E5%B0%B1%E6%80%8E%E4%B9%88%E4%B9%88",
                                        UTF8));

    }

    /**
     * Decode 1.
     */
    @Test
    public void decode1(){
        String str = "%E9%A3%9E%E5%A4%A9%E5%A5%94%E6%9C%88";
        LOGGER.debug(URIUtil.decode(str, "utf-8"));
    }

    /**
     * Decode2.
     */
    @Test
    public void decode2(){
        LOGGER.debug(URIUtil.decode("aaaaa%chu111", UTF8));

    }

    /**
     * Decode3.
     */
    @Test
    public void decode3(){
        LOGGER.debug(URIUtil.decode("%c", UTF8));
    }

    //****************com.feilong.core.net.URIUtil.getQueryString(String)********************************************
    /**
     * Test get query string.
     */
    @Test
    public void testGetQueryString(){
        assertEquals("a=1&a=2", URIUtil.getQueryString("http://127.0.0.1/cmens/t-b-f-a-c-s-f-p-g-e-i-o.htm?a=1&a=2"));
        assertEquals("a=1&a=2?a", URIUtil.getQueryString("http://127.0.0.1/cmens/t-b-f-a-c-s-f-p-g-e-i-o.htm?a=1&a=2?a"));
        assertEquals("", URIUtil.getQueryString("?"));
        assertEquals("a", URIUtil.getQueryString("?a"));
    }

}
