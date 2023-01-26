package tn.banque.Services;

import org.springframework.stereotype.Service;

@Service
public class SimulateurServiceImpl implements simulateurService {

	@Override
	public String simulationInterestImmobilierAtauxFixe(double capital, int mois ,double revenu_mensuel) {
		
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		double mensualite = 0;
		 
		if(mois<=84) {
			interest=0.17;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);
			 
		
		}
		if((84<mois) && (mois<=120)){
			interest=0.18;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);
		
		}
		
		 if((120<mois) && (mois<=180)){
			interest=0.2;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		 if((180<mois) && (mois<=240)){
		interest=0.215;
		 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
		
		 total = mensualite * mois;
		 mantantinterest = calculMantantInterest(capital,total);}
	
		 if((240<mois) && (mois<=300)){
			interest=0.225;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		double c = capital ;
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
		
		
	}

	@Override
	public double calculMensualiteTauxFixe(double capital, int mois, double interest) {
		double mens=0;
		mens=(capital*(interest/12))/
				(1-Math.pow((1+interest/12),-mois));
		return mens;
	}

	@Override
	public double calculMantantInterest(double capital, double montantTotal) {
		return montantTotal - capital;
	}

	@Override
	public String simulationInterestveheculeAtauxFixe(double capital, int mois, double revenu_mensuel) {
		
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		
		double mensualite = 0;
		 
		if(mois==36) {
			interest=0.25;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		
		if(mois==48){
			interest=0.299;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		
		if(mois==60){
			interest=0.349;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		if(mois==72){
		interest=0.4;
		 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
		  
		 total = mensualite * mois;
		 mantantinterest = calculMantantInterest(capital,total);}
	
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
	}

	@Override
	public double calculMensualiteTauxVariable(double capital, int mois, double interest) {
		double mens=0;
		mens=(capital*interest*Math.pow((1+interest),mois))/
				(Math.pow((1+interest),mois)-1);
		return mens;
	}

	@Override
	public String simulationInterestPersonnelAtauxFixe(double capital, int mois, double revenu_mensuel) {
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		
		double mensualite = 0;
		 
	
		
		
		if(mois==48){
			if(capital<5000) {
			interest=0.72;
			 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=5000)&&(capital<10000)) {
				interest=0.239;
				 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=10000)&&(capital<15000)) {
				interest=0.299;
				 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=10000)&&(capital<15000)) {
				interest=0.33;
				 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
		}
		
		
		if(mois==60){
			if(capital<5000) {
				interest=0.77;
				 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=5000)&&(capital<10000)) {
					interest=0.41;
					 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=10000)&&(capital<15000)) {
					interest=0.349;
					 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=10000)&&(capital<15000)) {
					interest=0.44;
					 mensualite = calculMensualiteTauxFixe(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}}
		
		
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
	}

	@Override
	public String simulationInterestImmobilierAtauxVariable(double capital, int mois, double revenu_mensuel) {
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		double mensualite = 0;
		 
		if(mois<=84) {
			interest=0.17;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);
			 
		
		}
		if((84<mois) && (mois<=120)){
			interest=0.18;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);
		
		}
		
		 if((120<mois) && (mois<=180)){
			interest=0.2;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		 if((180<mois) && (mois<=240)){
		interest=0.215;
		 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
		
		 total = mensualite * mois;
		 mantantinterest = calculMantantInterest(capital,total);}
	
		 if((240<mois) && (mois<=300)){
			interest=0.225;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		double c = capital ;
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
		
		
	}

	@Override
	public String simulationInterestveheculeAtauxVariable(double capital, int mois, double revenu_mensuel) {
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		
		double mensualite = 0;
		 
		if(mois==36) {
			interest=0.25;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		
		if(mois==48){
			interest=0.299;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		
		if(mois==60){
			interest=0.349;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
		
		if(mois==72){
		interest=0.4;
		 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
		  
		 total = mensualite * mois;
		 mantantinterest = calculMantantInterest(capital,total);}
	
		
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
	}

	@Override
	public String simulationInterestPersonnelAtauxVariable(double capital, int mois, double revenu_mensuel) {
		double interest = 0 ;
		double total = 0 ;
		double mantantinterest = 0;
		
		double mensualite = 0;
		 
	
		
		
		if(mois==48){
			if(capital<5000) {
			interest=0.72;
			 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
			 
			 total = mensualite * mois;
			 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=5000)&&(capital<10000)) {
				interest=0.239;
				 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=10000)&&(capital<15000)) {
				interest=0.299;
				 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
			if((capital>=10000)&&(capital<15000)) {
				interest=0.33;
				 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
		}
		
		
		if(mois==60){
			if(capital<5000) {
				interest=0.77;
				 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
				 
				 total = mensualite * mois;
				 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=5000)&&(capital<10000)) {
					interest=0.41;
					 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=10000)&&(capital<15000)) {
					interest=0.349;
					 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}
				if((capital>=10000)&&(capital<15000)) {
					interest=0.44;
					 mensualite = calculMensualiteTauxVariable(capital, mois , interest) ;
					 
					 total = mensualite * mois;
					 mantantinterest = calculMantantInterest(capital,total);}}
		
		
		
		return  " Your loan of     : " +capital +"\n "+ "Monthly Payments : "+ mensualite +"\n "
		+ "Interest Rate    : " +interest +"\n "
				
				+"Total Interest   : " +mantantinterest +"\n "+ "Total Payment    : " + total ;
		
		
		
	}
	

}
