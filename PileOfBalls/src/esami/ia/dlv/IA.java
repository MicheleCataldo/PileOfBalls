package esami.ia.dlv;

public class IA {
	java.util.ArrayList<esami.ia.pileofballs.Lista> risultato;
	java.util.ArrayList<esami.ia.pileofballs.Lista> vuoto;
	int num;
	
	public IA(){}
	
	public java.util.ArrayList<esami.ia.pileofballs.Lista> scegliPosizione(java.util.ArrayList<esami.ia.pileofballs.Lista> occupati, java.util.ArrayList<esami.ia.pileofballs.Lista> tripla, java.util.ArrayList<esami.ia.pileofballs.Lista> triplasucc, java.util.ArrayList<esami.ia.pileofballs.Pair> costo){
		
		this.risultato = new java.util.ArrayList<esami.ia.pileofballs.Lista>();
		this.vuoto = new java.util.ArrayList<esami.ia.pileofballs.Lista>();
		
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
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(triplasucc,"elsucc"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'triplasucc::elsucc' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(num,"num"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(costo,"costop"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'costo::costop' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(num,"num"), 0));

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
			_JDLV_PROGRAM_EXECUTING.addText("scelta(ID,I,J,COL) v noscelta(ID,I,J,COL) :- occ(ID,I,J,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("coloritripla(COL) :- el(_,_,_,COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- not #count{ID:scelta(ID,_,_,_)} = 1."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- scelta(_,_,_,COL), not coloritripla(COL)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), I1=I2, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), I1=I2, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), J1=J2, I2=I1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), J1=J2, I2=I1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), dispari(I1), I2=I1-1, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), dispari(I1), I2=I1+1, J2=J1-1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), pari(I1), I2=I1+1, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicini(ID,V,COL) :- scelta(ID,I1,J1,_), occ(V,I2,J2,COL), pari(I1), I2=I1-1, J2=J1+1, ID<>V."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("vicinidiversi(ID,V) :- scelta(ID,_,_,COL1), vicini(ID,V,COL2), COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), I=11, J>0, J<9, M=4."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), dispari(I), J=0, M=3."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), dispari(I), J>7, M=3."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), pari(I), J=0, M=5."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), pari(I), J>7, M=5."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), I=11, J=0, M=2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), I=11, J=9, M=2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("maxvicini(ID,M) :- scelta(ID,I,J,_), I<11, J>0, J<8, M=6."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText("eldiversi(ID, COL2) :- scelta(_,_,_,COL1), el(ID,_,_,COL2), COL1<>COL2."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":- #count{V:vicini(_,V,_)} = M, maxvicini(_,M)."+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ vicinidiversi(ID,V). [1:1]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ vicini(ID,V,COL). [1:1]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ eldiversi(ID,COL). [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ eldiversi(ID,COL1), vicini(_,V,COL2), vicinidiversi(_,V), COL1<>COL2. [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ el(ID1,_,_,COL1), elsucc(ID2,_,_,COL2), COL1<>COL2. [1:2]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ costop(ID, C), scelta(ID,_,_,_). [C:3]"+'\n');
			_JDLV_PROGRAM_EXECUTING.addText(":~ scelta(_,I,_,_), X=11-I. [X:3]"+'\n');
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
