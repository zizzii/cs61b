public class NBody {
    public static double readRadius(String s){
        In in = new In(s);;
        int numberPlanets = in.readInt();
        double RadiusUniverse = in.readDouble();
        return RadiusUniverse;
    }
    public static Planet[] readPlanets(String s){
        In in = new In(s);
        int numberPlanets = in.readInt();
        double RadiusUniverse = in.readDouble();
        Planet[] array = new Planet[numberPlanets];
        for(int i =0;i<numberPlanets;i++){
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            array[i] = new Planet(xPos,yPos,xVel,yVel,mass,imgFileName);
        }
        return array;
    }

    public static int readSize(String s){
        In in = new In(s);
        int numberPlanets = in.readInt();
        return numberPlanets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        int size = readSize(filename);
        double r = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setXscale(-r,r);
        StdDraw.setYscale(-r,r);
        StdDraw.picture(0,0,"images/starfield.jpg");

        for(Planet p : planets){
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while(time != T){
            double[] xForces = new double[size];
            double[] yForces = new double[size];
            for(int i =0;i<size;i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(Planet p : planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }


    }
}
