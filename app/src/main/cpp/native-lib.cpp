#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_ludi_olegmoney_util_Keys_baseUrl(JNIEnv* env,jobject /* this */) {
    std::string baseUrl = "https://api-om.dionpamungkas.com";
    return env->NewStringUTF(baseUrl.c_str());
}