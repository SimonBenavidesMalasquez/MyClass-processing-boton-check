package mylibrary.boton.check;

import mylibrary.boton.check.Clase_Opacidad_btn_check;
import processing.core.PApplet;

public class ToolTipText_btn_check {
	// myParent is a reference to the parent sketch
	PApplet p;
	
    // ACTIVA 
    boolean            activa_toolTipText = false ;
   
    // TEXTO ToolTipText : 
    String                    toolTipText = "" ;
        
    // PARA toolTipText       
    Clase_Opacidad_btn_check   opacidad_toolTipText ;     
 
         
	public ToolTipText_btn_check(PApplet theParent) {
		
		// INITIALIZE : 
		p = theParent ;
		
        // OPACIDAD CON ACTIVADOR : 
        opacidad_toolTipText = new Clase_Opacidad_btn_check("150-255");
		
	}
	
    public void show(){                            
        
        // Longitud texto disponible
        int w_texto = asigna_longitud_text( toolTipText );

         // Ancho cuadro
        int w_toolTip = (int)(w_texto*6.0) ;  

        // Opacidad 
        int op_tooTip = opacidad_toolTipText.getValue() ;

        // Para retener visualizacion un instante 
        if( op_tooTip < 250 ){
            op_tooTip = 0 ;
        }

        // CUADRO Y TEXTO : 
        if( p.mouseX >= p.width*0.5 &&  p.mouseX < p.width && p.mouseY > 0 && p.mouseY <= p.height*0.5 ){
         
              //cuadrante_cursor( "I" ); 
              dibuja_cuadro ( p.mouseX - (int)(w_toolTip*0.8), p.mouseY + 15, w_toolTip, 22 ,  op_tooTip );
              dibuja_texto  ( p.mouseX - (int)(w_toolTip*0.3), p.mouseY + 30, op_tooTip );

        }else if( p.mouseX >= 0 && p.mouseX < p.width*0.5 && p.mouseY > 0 && p.mouseY <= p.height*0.5 ){
          
              //cuadrante_cursor( "II" ); 
              dibuja_cuadro ( p.mouseX - (int)(w_toolTip*0.2), p.mouseY + 15, w_toolTip, 22 ,  op_tooTip );
              dibuja_texto  ( p.mouseX + (int)(w_toolTip*0.3), p.mouseY + 30, op_tooTip );


        }else if( p.mouseX >= 0 && p.mouseX < p.width*0.5 && p.mouseY > p.height*0.5 && p.mouseY < p.height ){
        
              //cuadrante_cursor( "III" ); 
              dibuja_cuadro ( p.mouseX - (int)(w_toolTip*0.2), p.mouseY + 15, w_toolTip, 22 ,  op_tooTip );
              dibuja_texto  ( p.mouseX + (int)(w_toolTip*0.3), p.mouseY + 30, op_tooTip );
              
        }else{
          
              //cuadrante_cursor( "IV" ); 
              dibuja_cuadro ( p.mouseX - (int)(w_toolTip*0.8), p.mouseY + 15, w_toolTip, 22 ,  op_tooTip );
              dibuja_texto  ( p.mouseX - (int)(w_toolTip*0.3), p.mouseY + 30, op_tooTip );
        }

        // EJECUTA SOLO SI LA FUNCION ES LLAMADA
        opacidad_toolTipText.bucle();
        opacidad_toolTipText.setOff();
     }

      public void dibuja_cuadro( int x, int y , int w , int h , int op ){

          // Cuadro 
    	  p.strokeWeight(1.2f); p.stroke(122,122,84, op ); p.fill(91,91,66, op );
    	  p.rect( x , y , w , h , 3 );
    	  p.strokeWeight(1.0f);

      }

       public void dibuja_texto( int x, int y , int op ){

          // Texto 
    	   p.textSize(11); p.textAlign(p.CENTER); p.fill(250, op);
    	   p.text( toolTipText , x , y ); 

      }
       
       
       // -------------------------------------- ABSTRACCION CODIGO : --------------------------------------
       public void opacidad_desactivado(){

           // ESTA EN ON, PORQUE SE INVIRTIO 
       	  opacidad_toolTipText.setOn();

           // TUVIMOS QUE PONER A BAJO, PARA QUE DIBUJA A 0
       	  opacidad_toolTipText.salida = 0 ;
       
       } 


       public void setToolTipText( String text_input ){           
          
            toolTipText = text_input ;
            
            // ACTIVA TEXTO toolTipText : 
            activa_toolTipText = true ;

       }

       public int asigna_longitud_text( String in_texto ){        
                 
                  int longitud_texto = 0 ;

                  if( in_texto.length() <= 10 ){
                      longitud_texto = 10 ;
                  }else if( in_texto.length() > 10 ){
                      longitud_texto = in_texto.length() ;
                  }

                  return longitud_texto ;
           
       }

       public boolean getStateToolTipText(){                      
            
             // SI HAY TEXTO , ASUME QUE ESTA ACTIVO
             if( toolTipText.length() > 0 ){
                 return true;
             }else{
                 return false ;
             }
     
       }
	
	
	
}
