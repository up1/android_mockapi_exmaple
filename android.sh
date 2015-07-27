export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/
export ANDROID_HOME=/Users/somkiat/data/software/android-sdk-macosx
./gradlew clean assembleDevDebug
cd calabash
rm app.apk
cp ../app/build/outputs/apk/app-dev-debug-unaligned.apk app.apk
calabash-android resign app.apk
calabash-android run app.apk --tags @dev  --format json --out report.json --format pretty

