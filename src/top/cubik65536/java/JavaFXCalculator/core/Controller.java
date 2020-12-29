package top.cubik65536.java.JavaFXCalculator.core;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    // 初始化变量
    boolean isCalculationSymbolEntered = false; // 运算符是否已输入
    boolean isFirstNum = true; // 正在输入的是否为第一个要运算的数，初始化为true
    String firstNumString = ""; // 第一个要运算的数
    String secondNumString = ""; // 第二个要运算的数

    // 注册UI模块
    // 显示屏
    @FXML
    TextField display;
    private String displayingContents = ""; // 显示屏显示内容
    // 按键
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button0;
    @FXML
    Button buttonEquals;
    @FXML
    Button buttonPlus;
    @FXML
    Button buttonMinus;
    @FXML
    Button buttonMultiply;
    @FXML
    Button buttonDivision;
    @FXML
    Button buttonESC;
    @FXML
    Button buttonClear;
    @FXML
    Button buttonClearAll;
    @FXML
    Button buttonDelete;
    @FXML
    Button buttonSquare;
    @FXML
    Button buttonQuadratic;
    @FXML
    Button buttonPower;
    @FXML
    Button buttonEvolution;
    @FXML
    Button buttonSin;
    @FXML
    Button buttonTan;
    @FXML
    Button buttonCos;
    @FXML
    Button buttonOpenParaentises;
    @FXML
    Button buttonCloseParaentises;
    @FXML
    Button buttonPi;
    @FXML
    Button buttonE;
    @FXML
    Button buttonReverse;

    // 绑定UI按键OnAction函数
    @FXML
    protected void button7Clicked(ActionEvent event) {
        System.out.println("button7Clicked");
        newButtonClicked("7");
    }
    @FXML
    protected void button8Clicked(ActionEvent event) {
        System.out.println("button8Clicked");
        newButtonClicked("8");
    }
    @FXML
    protected void button9Clicked(ActionEvent event) {
        System.out.println("button9Clicked");
        newButtonClicked("9");
    }
    @FXML
    protected void button4Clicked(ActionEvent event) {
        System.out.println("button4Clicked");
        newButtonClicked("4");
    }
    @FXML
    protected void button5Clicked(ActionEvent event) {
        System.out.println("button5Clicked");
        newButtonClicked("5");
    }
    @FXML
    protected void button6Clicked(ActionEvent event) {
        System.out.println("button6Clicked");
        newButtonClicked("6");
    }
    @FXML
    protected void button1Clicked(ActionEvent event) {
        System.out.println("button1Clicked");
        newButtonClicked("1");
    }
    @FXML
    protected void button2Clicked(ActionEvent event) {
        System.out.println("button2Clicked");
        newButtonClicked("2");
    }

    @FXML
    protected void button3Clicked(ActionEvent event) {
        System.out.println("button3Clicked");
        newButtonClicked("3");
    }

    @FXML
    protected void button0Clicked(ActionEvent event) {
        System.out.println("button0Clicked");
        newButtonClicked("0");
    }

    @FXML
    protected void buttonPlusClicked(ActionEvent event) {
        System.out.println("buttonPlusClicked");
        calculateButtonClicked((byte) 1, "+");
    }

    @FXML
    protected void buttonMinusClicked(ActionEvent event) {
        System.out.println("buttonMinusClicked");
        calculateButtonClicked((byte) 2, "-");
    }

    @FXML
    protected void buttonMultiplyClicked(ActionEvent event) {
        System.out.println("buttonMultiplyClicked");
        calculateButtonClicked((byte) 3, "×");
    }

    @FXML
    protected void buttonDivisionClicked(ActionEvent event) {
        System.out.println("buttonDivisionClicked");
        calculateButtonClicked((byte) 4, "÷");
    }

    /**
     * 更新显示屏显示内容函数（将displayingContents字符串内的内容显示在显示屏内）
     */
    private void refreshDisplayContent() {
        display.setText(displayingContents);
    }


    /**
     * 数字键触发函数，将数字转化成字符串，添加到显示内容和存储运算值的字符串中并更新显示屏
     * @param numString 数字的字符串值，由按键的onAction函数在调用时直接传递
     */
    private void newButtonClicked(String numString) {
        // 检测现在正在输入的是第一个还是第二个运算值
        if (isFirstNum) {
            // 是，向第一个值输入
            // 检测已有数字位数，超出限定位数24就不让再输入了
            // 换言之，如果已有24位就不再允许输入了
            if (firstNumString.length() < 24) {
                // 不到24位
                // 向运算值字符串中添加数字
                firstNumString = firstNumString + numString;
                // 向显示内容字符串中添加数字
                displayingContents = displayingContents + numString;
                // 更新显示内容
                refreshDisplayContent();
            }
        } else {
            // 否，向第二个值输入
            // 检测已有数字位数，超出限定位数24就不让再输入了
            // 换言之，如果已有24位就不再允许输入了
            if (secondNumString.length() < 24) {
                // 不到24位
                // 向运算值字符串中添加数字
                secondNumString = secondNumString + numString;
                // 向显示内容字符串中添加数字
                displayingContents = displayingContents + numString;
                // 更新显示内容
                refreshDisplayContent();
            }
        }
    }

    /**
     * 计算键触发函数，将按键符号加入显示内容并更新，数字键开始向第二个运算值字符串输入内容
     *
     * @param calculationType   运算类型，直接由按键的onAction函数在调用时传递，包含加（1）减（2）乘（3）除（4）乘方（5）开方（6），不包含二次方运算。该值不为1到6时报错并重新初始化程序
     * @param calculationSymbol 运算符符号，直接由由按键的onAction函数在调用时传递
     */
    private void calculateButtonClicked(byte calculationType, String calculationSymbol) {
        // 检测calculationType是否合格
        if (1 <= calculationType && calculationType <= 6) {
            // 合格
            // 判断第一个数是否已经有值（length不为0）
            if (firstNumString.length() > 0) {
                // 大于0（有值）
                // 向显示内容添加运算符号并更新
                displayingContents = displayingContents + calculationSymbol;
                refreshDisplayContent();
                // 开始像第二个数输入
                isFirstNum = false;
                return;
            }
            // 等于0（无值）
            // 不执行任何操作
            System.out.println("没有第一个运算值！不进行任何操作。");
            return;
        }
        // 不合格，不执行任何操作，向控制台输出提示
        System.out.println("calculateButtonClicked函数的calculationType值不符合要求！要求值为1到6，本次调用传入的值是：" + calculationType);
    }
}
