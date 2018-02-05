package com.luo.util;

/**
 * Created by Administrator on 2017/8/30.
 */
public class TestNum {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    // ②获取下一个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        /*TestNum sn = new TestNum();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();*/
        String str="-----BEGIN RSA PRIVATE KEY----- MIIEowIBAAKCAQEA450KzPFAj91VV8KkhJpQM+CareD/a7ZeDBoiSssLIMhwQa1f 2O00M58IBWjWC7QhlpBc1wEFEqBkmDfDwX7mkugX8w0PCcMgSOQWB4s2x8EYVXto N2/WmDL5XYos4gA4E70YTCrwj1RNpXQHFnWHsB5egrUPfRpeaxM2dZ8tRmbIxLaa 0bn8z2aFRHJa17hQ/qEKqyuAYSe0fFD71DSxwxaH1o11YFa0JVSA4WxGC7iZzow9 CdNetWrPcMyjU3b1aoGZDh6JQsYd5S38H6J4jScvTBBopprEEBj9Roclc/0sFTg3 t6y2XxKpXRFGk2d4wpafW75hX8SpsqAqqYtZHQIDAQABAoIBAEPvtq6O/48xJ+zm 2sX9bRze2Cw38OTMbOu9zSh3zB1/1gm0XtxXiHIz8Gf075ZUsIXJFvzRgBscJopM crBJWTbV8XgJGMj4JaW79ltQEQy0NLgm+mc5iVqqNEXYHSdjm1lA4oSxeFW/euF8 bTUl5VcK6Xin5DSZ7z6UYHfhB9lv+jlCjw+f73IsYz+8nZMnU9BmshsSap0EO+Tz 3Rmo9LSsQ80DTGZjn3939V+o+bV8AHp0e0ODRquRh+qLC8/UdH6mSl/c6Q8OS/pP PqFD/yCrXo4CREfbxtSnfxuH7wbRtdgMnoNpvNB7zjQr4fFdTq7MkB4YsHP+UAI5 cM+z5UECgYEA8kPKaFodwofXPE4ybXqWvkud4H9fzRUiI0bDJNNfhyYpDl79a8ZM GAPf3orJXs0uKOdvWrhxCNk1mmWiQekWkBv83S9iH/4cQt9eWS5lTyU6j8zjjl0w /rUB7SGE25Q4ilX+2asEVeuSUn7bW2HjVuGS4A3RgDCu7At43Iyvk3ECgYEA8ISa XxD0LFO7qIy3PV6IYxQI4JJDHNppxw+T9skN1FwUo3KF0vQRhX0PfBbe4J26brls +1dA1GB3Ea5Mfo//upuvDsn50VNUZTCrQTMwxqq6cYrdTfNMV3uKz1liNf9t/EZU ubmuYX7Jmx5PmC17Y7GEikd9KNdCZQGAi/YVsm0CgYBKYhoRdCnTApZJQ9Ej4BHM l7b/qNwnQafboOxlsCiSfFr6uJuirZ3LedUQpRgy7ViQ4o5EEoFSMC7PGwl4pzJw SMeYueWs4P6YYbC8PQyKAmo6oLP1kBNtAPJ4dmQubxH1F3ZKKsIIB25DugNryWBd 2qCX/mYmr8vlWZhgTynRYQKBgQCflKvEJcCMZKYfJ/YwTreZXWKidgj3bOc//1MC K9X0L4A2DjdCh1PUyOxsPdR1HdHjwz3O6c6G2tZFserpEmvviXo2CsapH2vgk9Ec unVDa2W3DhbVsHbXmI26E6k5AJgeCSAP9mYAJBppxEu1QYAb3l19Tf96CJDx6XQ7 6PPuZQKBgEPuQRMcjAmmi5rJXuJjzxskGspBPMvTF+i9OIsChVD1yzvJnXEUXx+0 5jYbGitHLNrNMC81ohKozpUt4TJ0F0syNAjS1uyKmoSTfPk9Tcs9tXZSIHocxrBx sct4tAgqxOhjEAyTEnLfFkwW1piMffZ5Ds81ASFV5qbIKrqs2VJH -----END RSA PRIVATE KEY-----";
        str.replace(" ","");
        System.out.println(str);
    }

    private static class TestClient extends Thread {
        private TestNum sn;

        public TestClient(TestNum sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                // ④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }

}
