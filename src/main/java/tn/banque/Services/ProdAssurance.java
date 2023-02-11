package tn.banque.Services;

import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.banque.Entities.Credits;
import tn.banque.Entities.Produitassurance;
import tn.banque.Entities.User;

import tn.banque.Repositories.CreditsRepository;
import tn.banque.Repositories.ProdAssuraceRepo;

@Service
public class ProdAssurance implements IprodAssuranceService {
	@Autowired
	ProdAssuraceRepo prodrepo;
	@Autowired
	CreditsRepository crrepo;

	@Override
	public Produitassurance Ajouteruser(Produitassurance u) {
		return prodrepo.save(u);
	}

	@Override
	public Produitassurance Updateeruser(Produitassurance u) {
		// TODO Auto-generated method stub
		return prodrepo.save(u);
	}

	@Override
	public void DeleteUser(Long u) {
		Produitassurance p= prodrepo.findById(u).orElse(null);
prodrepo.delete(p);		
	}

	@Override
	public List<Produitassurance> DisplayAssurance() {
		return (List<Produitassurance>) prodrepo.findAll();
	}

	@Override
	public Double getMontantCreditAssuranceapayer(Long  idc) {
		Credits c  =crrepo.findById(idc).orElse(null);
	
		User u=c.getClientcr();
		int d=(new Date().getYear())-(u.getDatanaissance().getYear());
		if (d<=30)
		{
		if (u.isFumer())	
		{ c.setMontantassurance((float) (0.0011*c.getAmount()*12/c.getDureect()));
		crrepo.save(c);

			return (Double) (0.0011*c.getAmount()*12/c.getDureect());
		}
		else
		{c.setMontantassurance((float) (0.0023*c.getAmount()*12/c.getDureect()));
		crrepo.save(c);

			return (Double) (0.0023*c.getAmount()*12/c.getDureect());

		}
			
		}
		else if (30<d&&d<=40)
		{
			if (u.isFumer())	
			{c.setMontantassurance((float) (0.0017*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0017*c.getAmount()*12/c.getDureect());

			}
			else
			{c.setMontantassurance((float) (0.0040*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0040*c.getAmount()*12/c.getDureect());

			}
			
		}	
		else if (40<d&&d<=50)
		{
			
			if (u.isFumer())	
			{c.setMontantassurance((float) (0.0029*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0029*c.getAmount()*12/c.getDureect());

			}
			else
			{c.setMontantassurance((float) (0.0074*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0074*c.getAmount()*12/c.getDureect());

			}
		}
		else if (50<d&&d<=60)
		{
			if (u.isFumer())	
			{c.setMontantassurance((float) (0.0070*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0070*c.getAmount()*12/c.getDureect());

			}
			else
			{c.setMontantassurance((float) (0.0127*c.getAmount()*12/c.getDureect()));
			crrepo.save(c);

				return (Double) (0.0127*c.getAmount()*12/c.getDureect());

			}	
			
		}
		return null;
	}

	

	
	

}
