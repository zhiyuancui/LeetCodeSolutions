package solutions;

/**
 * 1287 Element Appearing More Than 25% in Sorted Array
 */
public class ElementAppearsMoreThanQuater {
    public int findSpecialInteger(int[] arr) {
        int l = arr.length;
        int pre = 0;//保存遍历时上一个数的大小
        int times = 0;//出现次数
        int res = 0;//结果数组位置

        for(int i = 0;i < l; i++){

            //如果前一个数和当前数相等，times增加，同时判断是否到达25%的出现率
            if(pre == arr[i]){
                times += 1;
                if(times > 0.25*l){
                    res = i;
                    break;
                }

                //如果前一个数和当前数不相等，说明是一个新的数，pre指向当前数，将它的出现次数重置为1
            }else{
                pre = arr[i];
                times = 1;
            }
        }

        return arr[res];
    }
}
