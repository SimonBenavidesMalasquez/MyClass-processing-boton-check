package mylibrary.boton.check;

import processing.core.*;


public class Clase_Crea_Boton_Check{
           
	      PApplet p ;
	
          // Variables del panel
          public int x0 = 0 ;  int ancho = 17 ;
          public int y0 = 0 ;  int alto  = 17 ;

          String           main_text = "vacio" ;

          // Preferencias :
          boolean    act_resalta_borde = true  ; 
          boolean         modo_Relleno = false ;  // Para que se rellene al señalar      
          
          boolean  activa_helpPosition = false ;  // AYUDA : Para ayudar a posicionar    

          //boolean  enable_redondeada = true ;   // esquina redondeada                  
          int               redondeado = 3 ;    

          // GROSOR BORDE - StrokeWeight(x.x) 
          float       grosor_borde_OFF = 1.5f ;
          float        grosor_borde_ON = 2.0f ;

          public    int r_stroke_OFF = 70 ;   int r_stroke_ON =   0 ; 
          public    int g_stroke_OFF = 70 ;   int g_stroke_ON = 110 ;
          public    int b_stroke_OFF = 70 ;   int b_stroke_ON = 175 ;

          public      int r_fill_OFF = 25 ;      int r_fill_ON = 25 ;
          public      int g_fill_OFF = 25 ;      int g_fill_ON = 25 ;
          public      int b_fill_OFF = 25 ;      int b_fill_ON = 25 ;

          Clase_Opacidad_btn_check   opacidad_helpPosition ;  // opacidad
          ToolTipText_btn_check                toolTipText ;  // Para campo

          boolean     activa  = false ; 
          boolean     visible = false ;

          // Constructor : 
          public Clase_Crea_Boton_Check( PApplet app , int x, int y , String text_boton ){
            
        	  p = app ;
        	  
              x0 = x ; 
              y0 = y ;

              main_text = text_boton ;

              opacidad_helpPosition = new Clase_Opacidad_btn_check("0-250");
              toolTipText           = new ToolTipText_btn_check(app);
              
          }

          public void show(){                                          

                if( getVisible() == true ){ 

                   // SET BORDE  :
                   dibuja_grosor_borde();

                   // SET STROKE : 
                   dibuja_stroke();

                   // SET FILL   : 
                   dibuja_fill();

                   // DIBUJA BOTON : CUADRITO
                   dibuja_boton(); 

                   // TEXTO DE BOTON: 
                   texto_boton();

                   // RESALTA BOTON :
                   resalta_borde_de_boton( act_resalta_borde );
             

                    // ACTIVA AYUDA POSICIONAR : 
                    if( activa_helpPosition == true ){

                         opacidad_helpPosition.bucle();
                         help_position_Check();
                    }


               }

          }

          public void texto_boton(){                                   

               int pos_x = x0 + ancho + 10 ;
               int pos_y = (int)( y0 + alto*0.85 ) ;

               // BOTON SEÑALADO : Limites
               if( mouseEntered() == true ){
                     
                     // SI BOTON ON
                     if( getState() == true ){

                        dibuja_texto( pos_x, pos_y , 250 );
                     
                     // SI BOTON OFF
                     }else if( getState() == false ){

                        dibuja_texto( pos_x, pos_y , 200 );
                     }

               // BOTON NO SEÑALADO 
               }else{
                  
                   // SI BOTON ON
                   if( getState() == true ){

                      dibuja_texto( pos_x, pos_y , 250 );

                   // SI BOTON OFF   
                   }else{

                      dibuja_texto( pos_x, pos_y , 150 );
                   }

               }

          }

          public void mousePressed(){                            
             
             // Aun no usado

          }

          public void mouseReleased(){

              // CLIC IZQUIERDO : 
              if( p.mouseButton == p.LEFT ){

                    // CAMPO SEÑALADO 
                    if( mouseEntered() == true ){
                         
                         if( activa == false ){
                             activa = true ;
                         }else{
                             activa = false ;
                         }

                    }
                    
              // CLIC DERECHO : 
              }else if( p.mouseButton == p.RIGHT ){

                   // NO USADO AUN...
              }

          }

          // -------------------------------------- ABSTRACCION CODIGO : --------------------------------------
         
          public void show_ToolTipText(){

               // CAMPO SEÑALADO : 
               if( mouseEntered() == true ){ // && getStateToolTipText() == true ){
                    
                    toolTipText.show();

               // CAMPO NO SEÑALADO :
               }else{

                   toolTipText.opacidad_desactivado();
               }

          }

          public void setToolTipText_Input( String text_input){

              // Al entregar texto, activa toolTipText
              toolTipText.setToolTipText( text_input );  
             
          }


          public void setPosition( int x, int y ){                

                x0 = x ;
                y0 = y ;

          }

          public void setRedondeado( int redondeado_check ){           

          	   redondeado = redondeado_check ;

          }

          public void activa_tema( int num_tema ){                     
                          
                // BOTON AZUL : 
                if( num_tema == 1 ){ 
                  
                    //     ON                      OFF 
                    r_stroke_ON =   20 ;      r_stroke_OFF = 100 ;
                    g_stroke_ON =   20 ;      g_stroke_OFF = 100 ;
                    b_stroke_ON =   20 ;      b_stroke_OFF = 100 ;

                    r_fill_ON =   0 ;         r_fill_OFF = 40 ;
                    g_fill_ON = 110 ;         g_fill_OFF = 40 ;
                    b_fill_ON = 175 ;         b_fill_OFF = 40 ;

                // BOTON BORRAR : 
                }else if( num_tema == 2 ){

                     //     ON                      OFF 
                    r_stroke_ON =   20 ;      r_stroke_OFF = 100 ;
                    g_stroke_ON =   20 ;      g_stroke_OFF = 100 ;
                    b_stroke_ON =   20 ;      b_stroke_OFF = 100 ;

                    r_fill_ON = 210 ;         r_fill_OFF = 40 ;
                    g_fill_ON =  10 ;         g_fill_OFF = 40 ;
                    b_fill_ON =  10 ;         b_fill_OFF = 40 ;

                }else if( num_tema == 3 ){

                     //     ON                      OFF 
                    r_stroke_ON =   20 ;      r_stroke_OFF = 80 ;
                    g_stroke_ON =   20 ;      g_stroke_OFF = 80 ;
                    b_stroke_ON =   20 ;      b_stroke_OFF = 80 ;

                    r_fill_ON =    0 ;         r_fill_OFF = 60 ;
                    g_fill_ON =  140 ;         g_fill_OFF = 60 ;
                    b_fill_ON =  220 ;         b_fill_OFF = 60 ;

                }

          }

          public void dibuja_texto(  int x, int y , int op_texto ){    

        	   p.textAlign( p.LEFT); p.textSize(13.0f); p.fill( op_texto );
        	   p.text( main_text , x , y );

          }

          public String getText(){                                     
          	
          	 return main_text ;
         
          }

          public void setText( String texto ){                         

          	   main_text = texto ;

          }

          public boolean getState(){                                   
   
               return activa ; 
          
          } 

          public boolean getVisible(){

               return visible ;

          }

          public void setState( boolean enable ){                      

          	   activa = enable ;

          }

          public void setVisible( boolean enable ){

              visible = enable ;
          }

          public void dibuja_boton(){                                  
              
               if( getState() == true ){

            	   p.rect( x0 + 2 , y0  +2 , ancho -4, alto-4 , redondeado ); 

            	   p.stroke( 60 ); p.noFill();
            	   p.rect( x0 , y0 , ancho, alto , redondeado ); 

               }else{
                  
            	   p.rect( x0 , y0 , ancho, alto , redondeado ); 

               }

               p.strokeWeight(1.0f);
         
          }

          public void resalta_borde_de_boton( boolean enable ){        

          	   // SI ESTA HABILITADO : Preferencias
               if( enable == true ){

                  // CURSOR DENTRO DE CAMPO : 
                  if( mouseEntered() == true ){

                       if( getState() == true  ){

                    	   p.stroke(200);  p.noFill();
                    	   p.rect( x0 , y0 , ancho, alto , redondeado); 

                       }else if( getState() == false  ){

                    	   p.stroke(150);  p.noFill();
                    	   p.rect( x0 , y0 , ancho, alto , redondeado ); 


                       }
                  }

               }
         
          }

          public void dibuja_grosor_borde(){                              
                 
                 if( getState() == true ){
                	 p.strokeWeight( grosor_borde_ON );
                 }else{
                	 p.strokeWeight( grosor_borde_OFF );
                 }
          
          }

          public boolean mouseEntered(){                               

               if( getVisible() == true ){ 

                   // RETORNA SI SE SEÑALO PANEL :
                   if( p.mouseX > x0 && p.mouseX < ( x0 + ancho ) && p.mouseY > y0 && p.mouseY < (y0+alto) ){
                      return true ;
                   }else{
                   	  return false ;
                   }

               }else{

                  return false ;
               }

          }

          public void dibuja_stroke(){                                 
               
           
                    if( getState() == true ){

                    	p.stroke( r_stroke_ON , g_stroke_ON, b_stroke_ON  );

                    }else if( getState() == false ){
                          
                        if( mouseEntered() == true ){
                           
                        	p.stroke( r_stroke_OFF , g_stroke_OFF, b_stroke_OFF );
                        }else{

                        	p.stroke( r_stroke_OFF , g_stroke_OFF, b_stroke_OFF  );
                        }

                        // MODO RELLENO : OPCIONAL 
                        modo_relleno_STROKE();

                    }


          }

          public void dibuja_fill(){                                   

                   if( getState() == true ){
                       
                	   p.fill( r_fill_ON , g_fill_ON, b_fill_ON );

                   }else if( getState() == false ){
                       
                       if( mouseEntered() == true ){

                    	   p.fill( r_fill_OFF , g_fill_OFF, b_fill_OFF );

                       }else{

                    	   p.fill( r_fill_OFF , g_fill_OFF, b_fill_OFF );

                       }

                       // MODO RELLENO : OPCIONAL
                       modo_relleno_FILL();

                   }
          }

          public void modo_relleno_STROKE(){                           

                if( modo_Relleno == true ){
                    if( mouseEntered() == true ){
                    	p.stroke( r_stroke_ON , g_stroke_ON, b_stroke_ON );
                     }
                }

          }

          public void modo_relleno_FILL(){                             

                if( modo_Relleno == true ){
                    if( mouseEntered() == true ){
                    	p.fill( r_fill_ON , g_fill_ON, b_fill_ON );
                     }
                }

          }

          public void set_HelpPosition(){
             
               activa_helpPosition = true ;

          }

          public void help_position_Check(){                         


               int cap_x0 = p.mouseX ;
               int cap_y0 = p.mouseY ;
               
               
               if( activa_helpPosition == true ){

                     // CRUZ : p.
            	     p.stroke(0,110,175); p.fill(0,110,175);
            	     p.line( 0 , cap_y0 , p.width , cap_y0 );  // line horizontal up
            	     p.line( cap_x0 , 0 , cap_x0, p.height );  // line vertical left
                   
            	     p.stroke(0,110,175,100); p.fill(0,110,175,100);
            	     p.line( 0 , cap_y0 + alto , p.width , cap_y0 + alto);  // line horizontal low 
            	     p.line( cap_x0 + ancho, 0 , cap_x0+ancho, p.height );               // line vertical right
                    
                     // CUADRO CAMPO : 
            	     p.stroke( 255, opacidad_helpPosition.getValue() ); p.noFill();
            	     p.rect( cap_x0 , cap_y0 , ancho , alto , redondeado ); 

                     // TEXTO  VALOR MOUSEX, MOUSEY
            	     p.stroke(50); p.fill(10);
            	     p.rect( cap_x0 + 10 , cap_y0 - 67 , 150 , 25 , 5  );

            	     p.textSize(14); p.textAlign(p.LEFT); p.fill(0,150,220);
            	     p.text( "x : " + (cap_x0-x0), cap_x0 + 20, cap_y0  - 50 );
            	     p.textSize(14); p.textAlign(p.LEFT); p.fill(0,150,220);
            	     p.text( "y : " + (cap_y0-y0), cap_x0 + 80, cap_y0 - 50 );


               }

          }


}