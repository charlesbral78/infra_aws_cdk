package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class CursoAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

       VpcStack vpcStack = new VpcStack(app, "Vpc");

       ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
       //linha que indica a ordem que deve ser executado conforme suas dependencias
       clusterStack.addDependency(vpcStack);

       Service01Stack service01Stack = new Service01Stack(app, "Service01", clusterStack.getCluster());
        //linha que indica a ordem que deve ser executado conforme suas dependencias
       service01Stack.addDependency(clusterStack);

        app.synth();
    }
}

