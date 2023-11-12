/*
 * Copyright (c) 2015, Red Hat, Inc.
 * Copyright (c) 2015, Oracle, Inc.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.GHASH;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 4, time = 2)
@Measurement(iterations = 4, time = 2)
@Fork(value = 3, jvmArgsAppend = {"--add-exports", "java.base/com.sun.crypto.provider=ALL-UNNAMED", "--add-opens", "java.base/com.sun.crypto.provider=ALL-UNNAMED"})
public class TestGHASH {

    @Param({
        "66e94bd4ef8a2c3b884cfa59ca342b2e",
        "b83b533708bf535d0aa6e52980d53b78",
    })
    String H;

    @Param({
        "",

        "feedfacedeadbeeffeedfacedeadbeef" + "abaddad2",

        "0388dace60b6a392f328c2b971b2fe78", 

        "42831ec2217774244b7221b784d0d49c" +
        "e3aa212f2c02a4e035c17e2329aca12e" +
        "21d514b25466931c7d8f6a5aac84aa05" +
        "1ba30b396a0aac973d58e091473f5985",

        "42831ec2217774244b7221b784d0d49c" +
        "e3aa212f2c02a4e035c17e2329aca12e" +
        "21d514b25466931c7d8f6a5aac84aa05" +
        "1ba30b396a0aac973d58e091",

        "61353b4c2806934a777ff51fa22a4755" +
        "699b2a714fcdc6f83766e5f97b6c7423" +
        "73806900e49f24b22b097544d4896b42" +
        "4989b5e1ebac0f07c23f4598",        
    })
    String data;

    Constructor<?> GHASH;
    Method UPDATE;
    Object hash;

    public TestGHASH() {
        try {
            Class<?> cls = Class.forName("com.sun.crypto.provider.GHASH");
            GHASH = cls.getDeclaredConstructor(byte[].class);
            GHASH.setAccessible(true);
            UPDATE = cls.getDeclaredMethod("update", byte[].class);
            UPDATE.setAccessible(true);
        } catch (Exception e) {
            System.out.println("QQ\n");
        }
    }


    public Object newGHASH(byte[] H) throws Exception {
        return GHASH.newInstance(H);
    }

    public static final String HEX_DIGITS = "0123456789abcdef";

    public static byte[] bytes(String hex) throws Exception {
        if ((hex.length() & 1) != 0) {
            throw new AssertionError();
        }
        byte[] result = new byte[hex.length() / 2];
        for (int i = 0; i < result.length; ++i) {
            int a = HEX_DIGITS.indexOf(hex.charAt(2 * i));
            int b = HEX_DIGITS.indexOf(hex.charAt(2 * i + 1));
            if ((a | b) < 0) {
                if (a < 0) {
                    throw new AssertionError(
                            "bad character " + (int) hex.charAt(2 * i));
                }
                throw new AssertionError(
                        "bad character " + (int) hex.charAt(2 * i + 1));
            }
            result[i] = (byte) ((a << 4) | b);
        }
        return result;
    }

    @Setup
    public void construct() throws Exception {
        hash = newGHASH(bytes(H));
    }

    @Benchmark
    public void updateGHASHStr() throws Exception {
        UPDATE.invoke(hash, bytes(data));
    }
}
