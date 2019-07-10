package io.xjar;

import io.xjar.jni.XJni;
import io.xjar.key.XKey;

/**
 * Spring-Boot 启动器
 *
 * @author Payne 646742615@qq.com
 * 2019/4/14 10:28
 */
public class XLauncher implements XConstants {
    public final String[] args;
    public final XDecryptor xDecryptor;
    public final XEncryptor xEncryptor;
    public final XKey xKey;

    public XLauncher(String... args) {
        this.args = args;
        XJni xJni = XJni.getInstance();
        XKey xKey = xJni.key();
        String algorithm = xKey.getAlgorithm();
        this.xDecryptor = new XJdkDecryptor(algorithm);
        this.xEncryptor = new XJdkEncryptor(algorithm);
        this.xKey = xKey;
    }

}
