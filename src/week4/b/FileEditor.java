package week4.b;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class FileEditor {

    private Scanner scanner = new Scanner(System.in);

    private File f;
    private ArrayList<String> dataInFile = new ArrayList<String>();

    public FileEditor(String filePath) throws IOException {
        String[] filePathSplit;
        String fileName;
        if (filePath.contains("\\")) {
            filePathSplit = filePath.split("\\\\");
        } else {
            filePathSplit = filePath.split("/");
        }
        filePath = ".";
        fileName = filePathSplit[filePathSplit.length - 1];
        filePathSplit[filePathSplit.length - 1] = ".";
        for (String folder : filePathSplit) {
            folder = folder.strip();
            if (folder.equals(".")) {
                continue;
            }
            filePath += File.separator + folder;
        }

        File dir = new File(filePath);
        dir.mkdirs();
        f = new File(filePath + File.separator + fileName);

            if (f.createNewFile()) {
                System.out.println("（新建文件：" + f.getPath() + "）");
            } else {
                readFile();
                printFile();
            }
    }

    /**
     * 处理命令
     * 添加行(add)，删除行(del)，退出(q)
     *
     * @param commend
     */
    public boolean commendHandler(String commend) throws IOException {
        boolean statue = false;
        switch (commend) {
            case "add":
                System.out.printf("输入要添加的行号，或在末尾添加（输入end）：");
                String lineNumIn = scanner.nextLine().strip();
                if (lineNumIn.equals("end")) {
                    System.out.printf("输入内容：");
                    statue = addToEndOfFile(scanner.nextLine());
                } else {
                    int lineNum = 0;
                    for (int i = 0; i < lineNumIn.length(); i++) {
                        lineNum += ((int) lineNumIn.toCharArray()[i] - '0') * (Math.pow(10,i));
                    }
                    if (lineNum <= 0 || lineNum > dataInFile.size()){
                        System.out.println("行号输入错误");
                    }else{
                        System.out.printf("输入内容：");
                        statue = addLine(lineNum, scanner.nextLine());
                    }
                }
                break;
            case "del":
                System.out.printf("要删除的行号：");
                statue = deleteLine(scanner.nextInt());
                break;
            case "q":
                System.out.println("退出");
                return false;
            default:
                System.out.println("输入错误");
                return true;
        }
        if (statue) {
            printFile();
        } else {
            System.out.println("出错了");
        }
        return true;
    }

    /**
     * 将文件中所有行读入dataInFile
     */
    private void readFile() {
        dataInFile = new ArrayList<String>();
        try (
                FileInputStream fis = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                dataInFile.add(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printFile() {
        readFile();
        System.out.println("File: " + f.getPath());
        for (int i = 0; i < dataInFile.size(); i++) {
            System.out.format("%3d| %s\n", i + 1, dataInFile.get(i));
        }
    }

    /**
     * 将dataInFile写入文件中
     */
    private boolean writeToFile() {
        try (
                FileOutputStream fos = new FileOutputStream(f);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw);
        ) {
            for (String line : dataInFile) {
                pw.println(line);
            }
            pw.flush();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 在某行之前插入新的一行
     *
     * @param lineNum 在第几行之后插入
     * @param line    插入的行数据
     * @return
     */
    private boolean addLine(int lineNum, String line) {
        if (f == null) {
            return false;
        }
        readFile();
        dataInFile.add(lineNum - 1, line);
        return writeToFile();
    }

    /**
     * 在文件末尾插入一行
     *
     * @param line 插入的行数据
     * @return 是否成功
     * @throws IOException
     */
    private boolean addToEndOfFile(String line) throws IOException {
        if (f == null) {
            return false;
        }

        try (
                FileWriter fileWriter = new FileWriter(f, true)
        ) {
            fileWriter.append(line).append("\r\n");
            fileWriter.flush();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * 删除一行
     *
     * @param lineNum 要删除的行号
     * @return
     */
    private boolean deleteLine(int lineNum) {
        dataInFile.remove(lineNum - 1);
        return writeToFile();
    }

}
