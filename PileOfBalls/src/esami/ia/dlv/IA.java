package esami.ia.dlv;

public class IA {
	java.util.ArrayList<esami.ia.pileofballs.Lista> risultato;
	java.util.ArrayList<esami.ia.pileofballs.Lista> vuoto;
	int num;
	
	public IA(){}
	
	public java.util.ArrayList<esami.ia.pileofballs.Lista> scegliPosizione(java.util.ArrayList<esami.ia.pileofballs.Lista> occupati, java.util.ArrayList<esami.ia.pileofballs.Lista> tripla){
		
		this.risultato = new java.util.ArrayList<esami.ia.pileofballs.Lista>();
		this.vuoto = new java.util.ArrayList<esami.ia.pileofballs.Lista>();
		this.num = occupati.size()-1;
		
		// ---- START - startProgram ---- 
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation EXECUTING JDLV module.");
		it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING=new it.unical.mat.wrapper.DLVInputProgramImpl();
		_JDLV_PROGRAM_EXECUTING.cleanText();
		java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING=new java.lang.StringBuffer();
		it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

		// ---- END - startProgram ---- 
		
		// ---- START - addInMapping ---- 
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(occupati,"occ"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'occupati::occ' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(occupati,"occ"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(tripla,"el"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'tripla::el' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(tripla,"el"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(num,"num"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'num::num' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(num,"num"), 0));

		// ---- END - addInMapping ---- 
		
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'risultato::scelta' in module EXECUTING.");
		
		try{

			_JDLV_INVOCATION_EXECUTING=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
			_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING.toString());
			_JDLV_PROGRAM_EXECUTING.getFiles().clear();
			_JDLV_PROGRAM_EXECUTING.addText("pari(0)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(2)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(4)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(6)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(8)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("pari(10)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(1)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(3)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(5)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(7)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(9)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("dispari(11)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("s(ID,I,J,COL) v nos(ID,I,J,COL) :- occ(ID,I,J,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("coloritripla(COL) :- el(_,_,_,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- not #count{J:s(_,_,J,_)} = 1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- s(_,_,J,_), J>8."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- s(_,_,_,COL), not coloritripla(COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), I1=I2, J2=J1+1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), I1=I2, J2=J1-1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), J1=J2, I2=I1-1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), J1=J2, I2=I1+1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), dispari(I1), I2=I1-1, J2=J1-1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), dispari(I1), I2=I1+1, J2=J1-1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), pari(I1), I2=I1+1, J2=J1+1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("nonvicini(ID,V) :- s(ID,I1,J1,COL1), occ(V,I2,J2,COL2), pari(I1), I2=I1-1, J2=J1+1, ID<>V, COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ nonvicini(ID,V). [1:1]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("scelta(A,B,X,Y) :- s(A,B,X,Y)."+'\n');

			_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
			_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
			it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_EXECUTING);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution EXECUTING program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_EXECUTING.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_EXECUTING.getInputProgram().getCompleteText(),0));
			_JDLV_INVOCATION_EXECUTING.run();
			while(_BUFFERED_HANDLER_EXECUTING.hasMoreModels()){
			it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING=_BUFFERED_HANDLER_EXECUTING.nextModel();
			it.unical.mat.jdlv.program.TypeSolver.loadPredicate(risultato, "scelta",_temporary_JDLV_MODELEXECUTING,esami.ia.pileofballs.Lista.class);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "risultato " + risultato.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(risultato,0));
			return risultato;
			}
			if(_JDLV_INVOCATION_EXECUTING.haveModel()==false){
			}
			if(!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()){
			throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING.getErrors().get(0).getText());
			}
			}
			catch(java.lang.Throwable _JDLV_EXCEPTION_EXECUTING){
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
			}
			_JDLV_PROGRAM_EXECUTING.cleanText();

				// ---- END - prepareJDLVCall ---- 
			if(!risultato.isEmpty()){
				System.out.println("Trovato");
				return risultato;
			}	
			else 
				return  vuoto ;
	} 
}
