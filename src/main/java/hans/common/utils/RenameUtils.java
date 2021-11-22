package hans.common.utils;

import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class RenameUtils {

    public static enum Mode {
        /**
         * 前缀
         */
        PREFIX,
        /**
         * 后缀
         */
        SUFIX,
        /**
         * 任意匹配字符
         */
        ANY,
        ;

    }
    @Test
    public void test() {
        RenameUtils.rename("D:\\hanshixiong6\\Desktop\\test",
                Mode.PREFIX, "h", "AAAA");

    }
    public static int rename(String absoluteDirectoryPath, Mode mode, String regex, String replacement) {
        File filePath = new File(absoluteDirectoryPath);
        if (!filePath.isDirectory()) {
            throw new RuntimeException("这不是一个路径");
        }
        File[] files = filePath.listFiles();
        if (files.length==0) {
            return 0;
        }
        for (File f: files) {
            String fileName = f.getName();
            if (Objects.equals(mode, Mode.PREFIX)) {
                String newName = fileName.replaceFirst(regex, replacement);
                String newFile = f.getParentFile().getAbsolutePath()+File.separator+newName;
                f.renameTo(new File(newFile));
            }
        }
        return files.length;
    }

}
