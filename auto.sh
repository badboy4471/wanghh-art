#! /bin/bash
LANG=en_US.UTF-8

function deploy(){
    duanqu_dir=$1
    tomcat_dir=$2
    cd ${tomcat_dir}

    echo '保存当前日志信息-------'
    cp logs/catalina.out  data/catalina.out.$(date +%Y%m%d%H%M%S)
    rm logs/*

    echo '删除 apps '
    rm webapps/* -r

    echo '删除work下的缓存'
    rm work/Catalina/localhost/* -r

    echo '部署--------------'

    cp ${duanqu_dir}/art-web/target/art.war webapps/art.war
    cp ${duanqu_dir}/art-weixin/target/artwx.war webapps/artwx.war
}

echo 'repo update----------------'
git checkout master
git pull origin master


echo 'rename database config'

cp /mnt/code/wanghh-art/art-dao/src/main/resources/online-dataSource.properties /mnt/code/wanghh-art/art-dao/src/main/resources/dataSource.properties


echo 'mvn clean ----------------'

mvn -Dmaven.test.skip clean package

echo 'kill tomcat---------------'
ps aux | grep tomcat | awk '{print $2}' | xargs kill -9

deploy `pwd` /mnt/tomcat

echo 'start tomcat--------------'

bin/startup.sh