//
// Created by Administrator on 2018/3/19.
//

#include "jni.h"
#include "com_yeucheng_jnitestdemo_MyJni.h"
JNIEXPORT jstring  JNICALL Java_com_yeucheng_jnitestdemo_MyJni_getStringFromJni
        (JNIEnv *env, jclass jclass1){
    return (*env)->NewStringUTF(env,"hell o ,师姐!哈哈哈哈哈哈哈哈哈");
};