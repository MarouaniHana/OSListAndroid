FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    wget \
    unzip \
    git \
    tzdata \
    && rm -rf /var/lib/apt/lists/*

RUN wget https://dl.google.com/android/repository/commandlinetools-linux-7583922_latest.zip -O /sdk.zip && \
    mkdir -p /opt/android-sdk-linux/cmdline-tools && \
    unzip /sdk.zip -d /opt/android-sdk-linux/cmdline-tools/ && \
    rm /sdk.zip && \
    mv /opt/android-sdk-linux/cmdline-tools/cmdline-tools /opt/android-sdk-linux/cmdline-tools/latest

ENV ANDROID_HOME /opt/android-sdk-linux
ENV PATH ${PATH}:${ANDROID_HOME}/cmdline-tools/latest/bin:${ANDROID_HOME}/platform-tools

RUN yes | sdkmanager --licenses && \
    sdkmanager "platform-tools" "platforms;android-30" "build-tools;30.0.3"

WORKDIR /app
COPY . /app

RUN chmod +x ./gradlew

ENV GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.parallel=false -Dorg.gradle.jvmargs='-Xmx2048m'"

ENV JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"

RUN ./gradlew build --no-daemon --stacktrace

EXPOSE 8080

CMD ["./gradlew", "assembleDebug"]
