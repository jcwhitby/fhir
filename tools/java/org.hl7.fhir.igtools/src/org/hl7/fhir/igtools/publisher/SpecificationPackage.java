package org.hl7.fhir.igtools.publisher;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.hl7.fhir.convertors.R2ToR4Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.context.SimpleWorkerContext.IContextResourceLoader;
import org.hl7.fhir.utilities.cache.PackageCacheManager.PackageInfo;

public class SpecificationPackage {

  private SimpleWorkerContext context;

//  public static SpecificationPackage fromPath(String path) throws FileNotFoundException, IOException, FHIRException {
//    SpecificationPackage self = new SpecificationPackage();
//    self.context = SimpleWorkerContext.fromPath(path);
//    return self;
//  }

//  public static SpecificationPackage fromClassPath(String path) throws IOException, FHIRException {
//    SpecificationPackage self = new SpecificationPackage();
//    self.context = SimpleWorkerContext.fromClassPath(path);
//    return self;
//  }
//
//  public static SpecificationPackage fromPath(String path, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
//    SpecificationPackage self = new SpecificationPackage();
//    self.context = SimpleWorkerContext.fromPath(path, loader);
//    return self;
//  }

  public SimpleWorkerContext makeContext() {
    return new SimpleWorkerContext(context);
  }

  public void loadOtherContent(PackageInfo pi) throws FileNotFoundException, Exception {
    context.loadBinariesFromFolder(pi);

  }

  public static SpecificationPackage fromPackage(PackageInfo pi, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException {
    SpecificationPackage self = new SpecificationPackage();
    self.context = SimpleWorkerContext.fromPackage(pi, loader);
    return self;
  }

  public static SpecificationPackage fromPackage(PackageInfo pi) throws FileNotFoundException, IOException, FHIRException {
    SpecificationPackage self = new SpecificationPackage();
    self.context = SimpleWorkerContext.fromPackage(pi, null);
    return self;
  }

}
