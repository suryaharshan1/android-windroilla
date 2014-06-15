int posx,posy,pposx,pposy,rv,i;

void setup(){
  size(400,560);
  i=1000;
  background(0);
  rv=width/10;
  posx=width/2;
  posy=height/2;
  pposx=posx+(int)random(rv);
   pposy=posy+(int)random(rv);
}


void draw(){
  while(i>0){
    stroke(random(255),random(255),random(255));
    fill(random(255),random(255),random(255),random(100));
    line(posx,posy,pposx,pposy);
   // ellipse(posx,posy,random(50),random(50));
    newValues();
   i--; 
  }
  
}

void newValues(){
  posx=pposx;
  posy=pposy;
 pposx=posx+(int)random(rv)*mul((int)random(2));
   pposy=posy+(int)random(rv)*mul((int)random(2));
  while(pposx>width  || pposx<0){
    pposx=posx+(int)random(rv)*mul((int)random(2));
  }
  while(pposy>height || pposy<0){
    pposy=posy+(int)random(rv)*mul((int)random(2));
  }
  
}

int mul(int n){
  if(n==0){
    return -1;
  }else{
    return 1;
  }
}
  
