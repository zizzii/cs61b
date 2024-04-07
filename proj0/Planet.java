public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img)
    {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos) +
                        (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
    }
    public double calcForceExertedBy(Planet p){
        return G*(this.mass * p.mass)/(this.calcDistance(p)*this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        return (this.calcForceExertedBy((p))*
                (p.xxPos-this.xxPos)/(this.calcDistance(p)));
    }
    public double calcForceExertedByY(Planet p){
        return (this.calcForceExertedBy((p))*
                (p.yyPos-this.yyPos)/(this.calcDistance(p)));
    }
    public double calcNetForceExertedByX(Planet[] p){
        double NetForceX = 0;
        for(int i =0;i<p.length;i++){
            if(this.equals(p[i])){
                continue;
            }
            NetForceX += this.calcForceExertedByX(p[i]);
        }
        return NetForceX;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double NetForceY = 0;
        for(int i=0;i<p.length;i++){
            if(this.equals(p[i])){
                continue;
            }
            NetForceY += this.calcForceExertedByY(p[i]);
        }
        return NetForceY;
    }
    public void update(double time, double ForceX, double ForceY){
        double accX = ForceX/this.mass;
        double accY = ForceY/this.mass;
        this.xxVel += accX*time;
        this.yyVel += accY*time;
        this.xxPos += this.xxVel*time;
        this.yyPos += this.yyVel*time;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
