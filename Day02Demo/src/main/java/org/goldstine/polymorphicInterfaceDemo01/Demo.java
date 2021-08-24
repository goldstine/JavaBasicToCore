package org.goldstine.polymorphicInterfaceDemo01;

public class Demo {

    public static void main(String[] args) {
        //买一台电脑
        Computer computer = new Computer();
        //买一个小米鼠标
        USB m = new Mouse("小米鼠标");

        computer.installUSB(m);

        //买一个键盘
        KeyBoard1 board1 = new KeyBoard1("一个键盘");
        computer.installUSB(board1);
    }

}

//定义电脑对象
class Computer {
    //对应一个安装USB设备入口
    public void installUSB (USB usb){//多态体现，为了兼容安装所有设备，所以通过接口进行接收
        usb.connect();

        //usb既可能是鼠标，也可能是键盘
        if(usb instanceof Mouse){
            Mouse m = (Mouse) usb;
            m.dbclick();
        }else if(usb instanceof KeyBoard1){
            KeyBoard1 k = (KeyBoard1) usb;
            k.keydown();
        }

        usb.unconnect();
    }
}


//定义两个设备实现USB规范
class Mouse implements USB{

    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    //双击   设备的独有功能
    public void dbclick(){
        System.out.println(name+"双击666");
    }

    @Override
    public void connect() {
        System.out.println(name+"成功加入设备。。。。");
    }

    @Override
    public void unconnect() {
        System.out.println(name+"成功拔出设备...");
    }
}
class KeyBoard1 implements USB{
    private String name;

    public KeyBoard1(String name) {
        this.name = name;
    }

    //键盘的独有功能
    public void keydown(){
        System.out.println(name+"按键");
    }

    @Override
    public void connect() {
        System.out.println("成功接入设备....");
    }

    @Override
    public void unconnect() {
        System.out.println("成功拔出设备....");
    }
}

//定义USB的规范，必须完成接入和拔出功能
interface USB{
    void connect();
    void unconnect();
}