package com.cy.algorithm.common;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * @Author: Lil-K
 * @Date: 2023/10/5
 * @Description:
 */
public class Demo {

//    @Test
    public void test_1() {
        ChannelSftp sftpChannel = null;
        Session session = null;
        try {
            JSch jsch = new JSch();
            jsch.setConfig("StrictHostKeyChecking", "no");
            session = jsch.getSession("root", "192.168.9.254", 22);
            session.setPassword("123456");
            session.connect();

            sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            String basePath = "/test/";
            List<?> files = sftpChannel.ls(basePath);

            ChannelSftp finalSftpChannel = sftpChannel;
            files.stream()
                    .map(v -> {
                        ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) v;
                        return basePath + entry.getFilename();
                    })
                    .filter(v -> !StringUtils.endsWith(v, "."))
                    .forEach(v -> {
                        InputStream ins = null;
                        try {
                            ins = finalSftpChannel.get(v);
                            // 创建特殊路径
                            URI uri = URI.create("sftp://"+"root"+":"+"123456"+"@"+"192.168.9.254"+":"+"22"+v);
//                            URI uri = new URI("sftp://" + finalSftpChannel.getSession().getHost() + v);
                            Path path = Paths.get(uri);
                            Files.newByteChannel(path);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        } finally {
                            try {
                                if (null != ins) {
                                    ins.close();
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }

            if (session != null) {
                session.disconnect();
            }
        }
    }

    @Test
    public void test_2() {

    }

}
